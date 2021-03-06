package cn.algorithm.leetcode;

/**
 * 给定正整数数组 A，A[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的距离为 j - i。
 * 一对景点（i < j）组成的观光组合的得分为（A[i] + A[j] + i - j）：景点的评分之和减去它们两者之间的距离。
 * 返回一对观光景点能取得的最高分。
 * 示例：
 * 输入：[8,1,5,2,6]；输出：11
 * 解释：i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11
 * 提示：
 * 2 <= A.length <= 50000
 * 1 <= A[i] <= 1000
 *
 * @author hongzhou.wei
 * @date 2020/6/17
 */
public class P1014_bestSightseeingPair {
    public static void main(String[] args) {
        int a[] = new int[]{8, 1, 5, 2, 6};
        System.out.println(maxScoreSightseeingPairA(a));
    }

    /**
     * 暴力解法，挨个遍历（超出时间限制）
     *
     * @param A
     * @return
     */
    static public int maxScoreSightseeingPair(int[] A) {
        int ret = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int t = A[i] + A[j] + i - j;
                if (t > ret) {
                    ret = t;
                }
            }
        }
        return ret;
    }

    /**
     * 过程中把 A[i]+i和 A[j]-j分别看成两个变量，而且相对于A[i]+i来说A[j]-j是不变的，这个相对不变是值A[j]是不变的，
     * 而j的变化是由i决定的，所以相对A[i]+i来说可以把A[j]-j看成不变的，
     * 遍历过程中我们总是取最大的变量值，以及记录他们相加最大的值
     *
     * @param A
     * @return
     */
    static public int maxScoreSightseeingPairA(int[] A) {
        // var = A[i]+i; plusMax = max( max(A[i]+i) + A[j] - j);
        int plusMax = 0, var = A[0] + 0;
        for (int j = 1; j < A.length; j++) {
            plusMax = Math.max(plusMax, var + A[j] - j);
            var = Math.max(var, A[j] + j);
        }
        return plusMax;
    }

}
