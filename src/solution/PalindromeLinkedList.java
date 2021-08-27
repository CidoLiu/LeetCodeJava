package solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @id 234
 * @author dongjin
 * @date 2020/11/9 15:25
 */
public class PalindromeLinkedList {

    // Definition for singly-linked list.
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /*
    * 将链表存入数组
    * 时间复杂度：O(n)
    * 空间复杂度：O(n)
    * */
    public boolean isPalindrome(ListNode head) {
        List<Integer> ary = new ArrayList<>();
        while (head != null) {
            ary.add(head.val);
            head = head.next;
        }
        int front = 0;
        int back = ary.size() - 1;
        while (front < back) {
            if (!ary.get(front).equals(ary.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }

    /*
    * 快慢指针，反转后半段链表
    * 时间复杂度：O(n)
    * 空间复杂度：O(1)
    * 弊端：需要修改原链表；就算计算完成后，将链表恢复原样，但当并发运行程序时，可能导致结果错误。
    * */
    public boolean isPalindromeLeetcode(ListNode head) {
        if (head == null) {
            return true;
        }
        // 使用快慢指针寻找链表的中间结点
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode half = slow.next;
        slow.next = null;

        // 反转后半段链表
        ListNode temp = new ListNode(0);
        ListNode p = half;
        while (p != null) {
            half = half.next;
            p.next = temp.next;
            temp.next = p;
            p = half;
        }

        // 判断链表前面是否相同，不用考虑奇数的中间节点了
        half = temp.next;

        // while (head != null) {
        //     System.out.println(head.val);
        //     head = head.next;
        // }
        // System.out.println();
        // while (half != null) {
        //     System.out.println(half.val);
        //     half = half.next;
        // }

        while (head != null && half != null) {
            if (head.val != half.val) {
                return false;
            }
            head = head.next;
            half = half.next;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromeLinkedList temple = new PalindromeLinkedList();
        System.out.println();
    }
}
