package cn.algorithm.leetcode;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，
 * 使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 示例：
 * 输入：nums = [-1,2,1,-4], target = 1；输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * <p>
 * 提示：
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 *
 * @author hongzhou.wei
 * @date 2020/6/18
 */
public class P0016_3sumClosest {
    public static void main(String[] args) {
        int a[] = new int[]{-1, 2, 1, -4};
        int b[] = new int[]{0, 2, 1, -3};

        System.out.println(threeSumClosest(a, -2));
        System.out.println(threeSumClosest(b, 1));
    }

    /**
     * 双指针法：
     * 1、先对整个数组升序排序（方便确定指针移动方式）
     * 2、初始化ret，遍历数组
     * 3、双指针循环，如果|target-sum| < |target-ret|，更新ret
     * 4、根据sum与target的大小移动左右指针（sum<target则需增大sum则移动左指针，反之右指针）
     *
     * @param nums
     * @param target
     * @return
     */
    static public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ret = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[l] + nums[r] + nums[i];
                // 比之前的值还小就更新值
                if (Math.abs(sum - target) < Math.abs(ret - target)) {
                    ret = sum;
                }
                // 移动指针
                if (sum < target) {
                    l++;
                } else if (sum > target) {
                    r--;
                } else {
                    return sum;
                }
            }
        }
        return ret;
    }
}
