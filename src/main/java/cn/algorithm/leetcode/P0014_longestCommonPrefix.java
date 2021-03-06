package cn.algorithm.leetcode;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * 示例 1:
 * 输入: ["flower","flow","flight"]；输出: "fl"
 * 示例 2:
 * 输入: ["dog","racecar","car"]；输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:所有输入只包含小写字母 a-z 。
 *
 * @author hongzhou.wei
 * @date 2020/6/15
 */
public class P0014_longestCommonPrefix {
    public static void main(String[] args) {
        String a[] = new String[]{"flower", "flow", "floweright"};
        String[] b = new String[2];
        System.out.println(longestCommonPrefix1(a));
        System.out.println(longestCommonPrefix(b));
    }

    /**
     * 横向扫描
     *
     * @param strs
     * @return
     */
    static public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String commPrefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (j = 0; j < strs[i].length() && j < commPrefix.length(); j++) {
                if (strs[i].charAt(j) != commPrefix.charAt(j)) {
                    break;
                }
            }
            commPrefix = commPrefix.substring(0, j);
        }
        return commPrefix;
    }

    /**
     * 纵向扫描
     *
     * @param strs
     * @return
     */
    static public String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
