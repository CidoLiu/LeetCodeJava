package solution;

/**
 * @author liudongjin
 * @id 148
 * @date 2021/1/24 15:58
 */
public class SortList148 {

    private class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    public ListNode sortList(ListNode head, ListNode tail) { // 这里的tail是尾部后边补位的Node？
        if (head == null) {
            return null;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);
        return mergeList(list1, list2);
    }

    /**
     * 递归合并两个升序列表
     *
     * @param list1 升序列表1的头节点
     * @param list2 升序列表2的头节点
     * @return ListNode 合并后列表的头节点
     */
    public ListNode mergeList(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val <= list2.val) {
            list1.next = mergeList(list1.next, list2);
            return list1;
        }
        if (list1.val > list2.val) {
            list2.next = mergeList(list1, list2.next);
            return list2;
        }
        return null;
    }

    public static void main(String[] args) {
        SortList148 temple = new SortList148();
        System.out.println();
    }

}
