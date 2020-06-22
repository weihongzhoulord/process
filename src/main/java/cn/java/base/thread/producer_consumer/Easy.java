package cn.java.base.thread.producer_consumer;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 生产者消费者简单模型
 * 1.阻塞队列
 * 2.生产者往队列中添加商品，若队列满了就wait()等待通知
 * 3.消费者从队列中取出商品，若队列空了就notify()通知消费者生产
 * 注意：必须有同步操作
 *
 * @author hongzhou.wei
 * @date 2020/6/15
 */
public class Easy {
	public static final int          MAX_POOL = 10;
	public static final Queue<Goods> QUEUE    = new ArrayBlockingQueue<>(MAX_POOL);

	public static void main(String[] args) {
		Producer producer = new Producer();
		Consumer consumer = new Consumer();
		for (int i = 0; i < 6; i++) {
			new Thread(producer, "生产者线程" + i).start();
		}
		for (int i = 0; i < 6; i++) {
			new Thread(consumer, "消费者线程" + i).start();
		}
	}
}

class Goods {
	private String name;

	public Goods(String name) {
		this.name = name;
	}
}

/**
 * 生产者类
 */
class Producer implements Runnable {
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (Easy.QUEUE) {
				// 队列未满，继续生产
				if (Easy.QUEUE.size() < Easy.MAX_POOL) {
					Easy.QUEUE.offer(new Goods("生产的商品"));
					System.out.println(Thread.currentThread().getName() + "生产了商品，商品总数为：" + Easy.QUEUE.size());
				}
				// 队列已满，停止生产，等待通知
				else {
					try {
						Easy.QUEUE.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}

/**
 * 消费者类
 */
class Consumer implements Runnable {
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (Easy.QUEUE) {
				// 有可消费的商品，开始消费
				if (!Easy.QUEUE.isEmpty()) {
					Easy.QUEUE.poll();
					System.out.println(Thread.currentThread().getName() + "消费了商品，商品总数为：" + Easy.QUEUE.size());
				}
				// 无可消费的商品，通知生产者生产
				else {
					Easy.QUEUE.notify();
				}
			}
		}
	}
}
