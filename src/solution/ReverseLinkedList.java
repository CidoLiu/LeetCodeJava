package solution;

/**
 * @author dongjin
 * @id 206
 * @date 2020/11/9 9:11
 */
public class ReverseLinkedList {

    // Definition for singly-linked list.
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /*
    * 迭代
    * 时间复杂度：O(n)
    * */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p = head;
        ListNode q = null;
        while (p != null) {
            ListNode temp = new ListNode(p.val);
            temp.next = q;
            q = temp;
            p = p.next;
        }
        return q;
    }

    /**
     * 递归
     * 时间复杂度：O(n)
     * @param head
     * @return
     */
    public ListNode reverseListRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseListRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ReverseLinkedList temple = new ReverseLinkedList();
        System.out.println();
    }
}
