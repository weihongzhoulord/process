package cn.algorithm.leetcode;

/**
 * @author hongzhou.wei
 * @date 2020/7/19
 */
public class A {
    public static void main(String[] args) {
//        int numBottles = 9, numExchange = 3;
        int numBottles = 15, numExchange = 4;
        System.out.println(numWaterBottles(numBottles, numExchange));
    }

    static public int numWaterBottles(int numBottles, int numExchange) {
        int count = numBottles;
        while (numBottles > numExchange) {
            count += numBottles / numExchange;
            numBottles = numBottles / numExchange + numBottles % numExchange;
        }
        return count;
    }
}