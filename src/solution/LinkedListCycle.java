package solution;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * @id 141
 * @author dongjin
 * @date 2020/11/7 14:28
 */

public class LinkedListCycle {

    // Definition for singly-linked list.
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /*
    * 使用HashSet集合存储所有的节点地址
    * 时间复杂度O(n)
    * 空间复杂度O(n)
    * */
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        Set<String> nextMemory = new HashSet<String>();
        while (head != null) {
            String temp = head.toString();
            if (nextMemory.contains(temp)){
                return true;
            }
            nextMemory.add(temp);
            head = head.next;
        }
        return false;
    }

    /*
    * Leetcode官方题解，快慢指针，使用两个指针，一个每次走一步，一个每次走两步，若两个指针相遇，则说明有环；若指针为空，则无环
    * 时间复杂度O(n)
    * 空间复杂度O(1)
    * */
    public boolean hasCycleFloyd(ListNode head) {
        if (head ==null || head.next == null) {
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && slow != null) {
            if (fast.next == null || fast.next.next == null) {
                return false;
            }
            if (fast == slow) {
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedListCycle temple = new LinkedListCycle();
        System.out.println();
    }
}
