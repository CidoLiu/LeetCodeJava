package solution;

import java.util.ArrayList;

/**
 * @author dongjin
 * @date 2020/10/2 14:00
 */


public class MergeTwoSortedLists {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
     /*
     * 官方题解：递归
     * 时间复杂度：O(n + m)
     * 空间复杂度：o(n + m)
     * */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
         if (l1 == null) {
             return l2;
         } else if (l2 == null) {
             return l1;
         } else if (l1.val < l2.val) {
             l1.next = mergeTwoLists(l1.next, l2);
             return l1;
         } else {
             l2.next = mergeTwoLists(l1, l2.next);
             return l2;
         }
    }

    /*
    * 官方题解：迭代
    * 时间复杂度：O(n + m)
    * 空间复杂度：O(1)
    * */
    public ListNode mergeTwoListsByIterate(ListNode l1, ListNode l2) {
        ListNode merge = new ListNode(-1);
        ListNode prev = merge;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        return merge.next;
    }

    public static void main(String[] args) {
        MergeTwoSortedLists temple = new MergeTwoSortedLists();

        ListNode l1 = new ListNode(1){};
        ListNode next, node;
        next = l1;
        node = new ListNode(2){};
        next.next = node;
        next = next.next;
        node = new ListNode(4){};
        next.next = node;
        next = next.next;

        ListNode l2 = new ListNode(1){};
        next = l2;
        int[] l2_data = {3, 4};
        for (int i: l2_data) {
            node = new ListNode(i);
            next.next = node;
            next = next.next;
        }

        ListNode merge = temple.mergeTwoListsByIterate(l1,l2);
        ListNode i = merge;
        while (i != null) {
            System.out.println(i.val);
            i = i.next;
        }
    }
}
