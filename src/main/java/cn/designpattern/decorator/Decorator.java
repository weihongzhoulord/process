package cn.designpattern.decorator;
/** 
 * @author whz 
 * @version on:2019-3-6 上午12:15:53
 * 装饰者模式：
	对已有的业务逻辑进一步的封装，使其增加额外的功能，如Java中的IO流就使用了装饰者模式，用户在使用的时候，可以任意组
	，达到自己想要的效果。 举个栗子，我想吃三明治，首先我需要一根大大的香肠，我喜欢吃奶油，在香肠上面加一点奶油，再放一点蔬菜，
	最后再用两片面包夹一下，很丰盛的一顿午饭，营养又健康。 首先，我们需要写一个Food类，让其他所有食物都来继承这个类 
 */
public class Decorator {
	public static void main(String[] args) {
//		Food food = new Bread(new Cream(new Vegetable(new Food("培根"))));
//		Food food = new Bread(new Cream(null));
//		System.out.println(food.make());
	}
}
