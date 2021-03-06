package cn.algorithm.base.problems;

import java.util.LinkedList;
import java.util.List;

/**
 * @author hongzhou.wei
 * @date 2020/6/29
 */
public class A2zSubSet {
    public static void main(String[] args) {
        f();
    }

    /**
     * 有一个集合由A-Z这26个字母组成，打印这个集合的所有子集，每个子集一行，不能使用递归(腾讯面试题)
     * Exception in thread "main" java.lang.OutOfMemoryError: GC overhead limit exceeded
     */
    static void f() {
        int n = 26;
        final char[] letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        List<String> res = new LinkedList<>();
        int maxNum = 1 << n;
        // 处理0到2^26之间的数
        for (int i = 0; i < maxNum; i++) {
            StringBuilder sb = new StringBuilder();
            // j表示二进制右数第j位
            for (int j = 0; j < n; j++) {
                // 当前位不为0就打印该字符
                if ((i & (1 << j)) != 0) {
                    sb.append(letters[j]);
                }
            }
            res.add(sb.toString());
            System.out.println(sb);
        }
        System.out.println(res.toString());
    }
}