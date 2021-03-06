package cn.algorithm.leetcode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author hongzhou.wei
 * @date 2020/6/17
 */
public class P0002_addTwoNumbers {
    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode curNode = new ListNode(0);
        ListNode retNode = curNode;
        int carry = 0;
        while (l1 != null || l2 != null) {
            // 处理链表长度不一致相加时补位
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            // 相加并处理进位
            int n = x + y + carry;
            carry = n / 10;
            curNode.next = new ListNode(n % 10);
            // 链表操作
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            curNode = curNode.next;
        }
        // 处理相加之后的最高位进位
        if(carry > 0){
            curNode.next = new ListNode(carry);
        }
        return retNode.next;
    }
}

class ListNode {
    int      val;
    ListNode next;
    ListNode(int x) { val = x; }
}