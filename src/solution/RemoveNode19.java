package solution;

public class RemoveNode19 {
    /**
     * 设链表长度为L，倒数第N个为正数第(L-N+1)个
     * 先求出链表长度，然后删除第(L-N+1)个节点
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        int len = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            len++;
        }
        System.out.println("len: " + len);
        // 若删除的是头节点
        if (n == len) {
            return head.next;
        }
        p = head;
        for (int i = 0; i < len - n - 1; i++) {
            p = p.next;
        }
        p.next = p.next.next;
        return head;
    }

    /**
     * 双指针
     */
    public ListNode removeNthFromEndDoublePointer(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode p = head;
        ListNode q = head;
        for (int i = 0; i < n; i++) {
            // q 先向后移动n次
            q = q.next;
        }
        if (q == null) {
            // q == null 说明删除的是头节点
            return head.next;
        }
        while (q.next != null) {
            p = p.next;
            q = q.next;
        }
        p.next = p.next.next;
        return head;
    }
}
