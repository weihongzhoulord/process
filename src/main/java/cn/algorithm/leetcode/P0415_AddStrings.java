package cn.algorithm.leetcode;

/**
 * 415. 字符串相加
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * <p>
 * 注意：
 * <p>
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 *
 * @author hongzhou.wei
 * @date 2020/8/3
 */
public class P0415_AddStrings {
    public static void main(String[] args) {
        String num1 = "1111211111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111";
        String num2 = "111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111";
        System.out.println(addStrings(num1,num2));
    }

    static public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int a = carry + (i >= 0 ? num1.charAt(i)-'0' : 0) + (j >= 0 ? num2.charAt(j)-'0' : 0);
            sb.append(a % 10);
            carry = a / 10;
        }
        if(carry > 0){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}