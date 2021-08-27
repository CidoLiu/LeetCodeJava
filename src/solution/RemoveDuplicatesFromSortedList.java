package solution;

/**
 * @id 83
 * @author dongjin
 * @date 2020/10/23 15:00
 */


public class RemoveDuplicatesFromSortedList {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /*
    * 自己的解法，写了两个while，思路太不清晰了，吃了3次运行时错误和wa
    * */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode now = head;
        int temp = head.val;
        while (now.next != null) {
            temp = now.val;
            while (now.next != null && temp == now.next.val) {
                now.next = now.next.next;
            }
            if (now.next == null) {
                break;
            }
            now = now.next;
        }
        return head;
    }

    /*
    * 官方题解，一目了然
    * */
    public ListNode deleteDuplicatesLeetcode(ListNode head) {
        ListNode now = head;
        while (now != null && now.next != null) {
            if (now.val == now.next.val) {
                now.next = now.next.next;
            } else {
                now = now.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList temple = new RemoveDuplicatesFromSortedList();
        ListNode list = new ListNode(1);
        ListNode next = list;
        int[] data = {1, 1, 1};
        for (int x: data) {
            ListNode newNode = new ListNode(x);
            next.next = newNode;
            next = next.next;
        }
        System.out.println(temple.deleteDuplicates(list));
    }
}

