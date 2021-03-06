package cn.algorithm.leetcode;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 * 示例 1:
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 * 输入: [1,3,5,6], 0
 * 输出: 0
 *
 * @author hongzhou.wei
 * @date 2020/7/17
 */
public class P0035_SearchInsertPosition {
    public static void main(String[] args) {
        int d[] = new  int[]{1,3,5,6};
        int t = 0;
        System.out.println(searchInsert(d,t));


        /*double a = 456.456;
        double b = 123.123;
        BigDecimal c =new BigDecimal(a).divide(new BigDecimal(b),2,RoundingMode.CEILING);
        System.out.println(c);*/
    }
    static public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if(target < nums[i]){
                return i;
            }
            if(target == nums[i]){
                return i;
            }
        }
        // 没有找到，且都比目标值小
        return nums.length;
    }
}
