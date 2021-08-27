package solution;

import java.util.HashSet;

/**
 * @author liudongjin
 * @date 2021/1/17 22:35
 */
public class LinkedListCycle142 {

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 建立HashSet记录所有经过的节点
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        HashSet<ListNode> set = new HashSet<>();
        ListNode p = head;
        set.add(p);
        while (p.next != null) {
            if (set.contains(p.next)) {
                return p.next;
            } else {
                set.add(p.next);
                p = p.next;
            }
        }
        return null;
    }

    /**
     * 快慢指针
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param head
     * @return
     */
    public ListNode detectCycleByFastSlowPoint(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slowPoint = head;
        ListNode fastPoint = head;
        while (true) {
            slowPoint = slowPoint.next;
            fastPoint = fastPoint.next;
            if (fastPoint != null) {
                fastPoint = fastPoint.next;
            }
            if (fastPoint == null){
                return null;
            }
            if (slowPoint.equals(fastPoint)) {
                ListNode prev = head;
                while (true) {
                    if (slowPoint.equals(prev)) { // 这里要先判断，再to next，考虑入环的第一个节点为头节点的情况
                        return prev;
                    }
                    slowPoint = slowPoint.next;
                    prev = prev.next;
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
