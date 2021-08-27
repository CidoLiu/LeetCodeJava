package solution;

/**
 * @author dongjin
 * @id 203
 * @date 2020/11/8 14:51
 */
public class RemoveLinkedListElements {

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /*
    * 首先解决头节点等于val的问题
    * */
    public ListNode removeElements(ListNode head, int val) {
        while (head != null ) {
            if (head.val == val) {
                head = head.next;
            } else {
                break;
            }
        }
        ListNode p = head;
        if (head == null) { // 若全为val，则返回一个null
            return null;
        }
        while (p.next != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return head;
    }

    /*
    * Leetcode官方解法，设置一个哨兵
    * */
    public ListNode removeElementsLeetcode(ListNode head, int val) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode prev = sentinel;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
                curr = curr.next;
            } else {
                curr = curr.next;
                prev = prev.next;
            }
        }
        return sentinel.next;
    }

    public static void main(String[] args) {
        RemoveLinkedListElements temple = new RemoveLinkedListElements();
        System.out.println();
    }
}
