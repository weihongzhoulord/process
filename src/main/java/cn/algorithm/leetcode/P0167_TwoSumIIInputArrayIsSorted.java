package cn.algorithm.leetcode;

import java.util.Arrays;

/**
 * 167. 两数之和 II - 输入有序数组
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * 说明:
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 *
 * @author hongzhou.wei
 * @date 2020/7/20
 */
public class P0167_TwoSumIIInputArrayIsSorted {
    public static void main(String[] args) {
       /*int [] numbers = new int[]{2,7,11,15};
       int target = 9;*/
        int [] numbers = new int[]{5,25,75};
        int target = 100;
        System.out.println(Arrays.toString(twoSum1(numbers,target)));
    }

   static public int[] twoSum(int[] numbers, int target) {
        for (int x = 0; x < numbers.length; x++) {
            for (int y = x+1; y < numbers.length; y++) {
                if(numbers[x] + numbers[y] == target){
                    return new int[]{x+1, y+1};
                }
            }
        }
       return new int[] {};
    }

    static public int[] twoSum1(int[] numbers, int target) {
        int len = numbers.length,  x=0, y = len -1;
        while (x < y){
            int t = numbers[x] + numbers[y];
            if(t == target){
                return new int[]{x+1, y+1};
            }else if(t > target){
                y--;
            }else {
                x++;
            }
        }
        return new int[] {};
    }
}
