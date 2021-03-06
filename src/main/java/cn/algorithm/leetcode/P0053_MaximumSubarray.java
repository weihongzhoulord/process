package cn.algorithm.leetcode;

/**
 * 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * @author hongzhou.wei
 * @date 2020/7/29
 */
public class P0053_MaximumSubarray {
    public static void main(String[] args) {
        int a[] = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(a));
        System.out.println(maxSubArray1(a));
    }

    /**
     * 【动态规划】
     * 思想：
     * 可对空间复杂度做进一步的优化，记录整体最大值、前一个元素位置处产生的最大值。
     * 状态：每个位置加上当前值能取得的最大值
     * 转移方程：max = Math.max(max, 加上当前值能取得的最大值)
     *
     * @param nums
     * @return
     */
    static public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int pre = 0, max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            pre = Math.max(nums[i], pre + nums[i]);
            max = Math.max(max, pre);
        }
        return max;
    }

    /**
     * 若前一个元素产生的最大值大于0，则将其加在当前元素上。最后返回最大值即可
     *
     * @param nums
     * @return
     */
    static public int maxSubArray1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int sum = 0, max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            // 前一个元素产生的最大值大于0 重新加
            if (sum < 0 && sum < nums[i]) {
                sum = nums[i];
            } else {
                // 累加
                sum += nums[i];
            }
            // 整体最大值
            max = Math.max(max, sum);
        }
        return max;
    }
}
