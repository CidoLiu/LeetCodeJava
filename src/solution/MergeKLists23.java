package solution;

import java.util.PriorityQueue;

public class MergeKLists23 {
    /**
     * 将合并K个有序链表拆分为合并两个有序链表
     * 时间复杂度：O(k^2 n)
     * 空间复杂度：O(1)
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null;
        for (int i = 0; i < lists.length; i++) {
            ans = mergeTwoList(ans, lists[i]);
//            System.out.println(ans.val);
        }
        return ans;
    }

    /**
     * 合并两个有序链表
     */
    public ListNode mergeTwoList(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        ListNode p = a;
        ListNode q = b;
        while (p != null && q != null) {
            if (p.val <= q.val) {
                tail.next = p;
                p = p.next;
            } else {
                tail.next = q;
                q = q.next;
            }
            tail = tail.next;
        }
        tail.next = p != null ? p : q;
        return head.next;
    }

    /**
     * 分治合并链表
     */
    public ListNode mergeKListsDivide(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        if (left > right) {
            return null;
        }
        int middle = left + (right - left) / 2;
        return mergeTwoList(merge(lists, left, middle), merge(lists, middle + 1, right));
    }

    /**
     * 使用优先队列
     * 渐进时间复杂度为 O(kn×logk)。
     * 渐进空间复杂度为 O(k)
     */
    public ListNode mergeKListsPriorityQueue(ListNode[] lists) {
        PriorityQueue<ListNode> q = new PriorityQueue<>((x,y)->x.val-y.val);
        for (ListNode node: lists) {
            if (node != null) {
                q.add(node);
            }
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (!q.isEmpty()) {
            tail.next = q.poll();
            tail = tail.next;
            if (tail.next != null) {
                q.add(tail.next);
            }
        }
        return head.next;
    }
}
