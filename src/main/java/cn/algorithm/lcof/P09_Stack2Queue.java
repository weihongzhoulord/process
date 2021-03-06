package cn.algorithm.lcof;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在
 * 队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 * @author hongzhou.wei
 * @date 2020/6/30
 */
public class P09_Stack2Queue {

}
class CQueue {
    /**
     * 栈1：入队列时用
     * 栈2：出队列时用，若栈2为空则将栈1的元素插到栈2，之后栈2依然为空则队列为空（返回-1）否则返回栈2的栈顶元素
     */

    Deque<Integer> stack1;
    Deque<Integer> stack2;
    public CQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            if(stack2.isEmpty()){
                return -1;
            }
        }
        return stack2.pop();
    }
}