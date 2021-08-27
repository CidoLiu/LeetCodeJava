package solution;

import java.util.HashSet;
import java.util.Set;

/**
 * @id 160
 * @author dongjin
 * @date 2020/11/7 19:41
 */
public class IntersectionOfTwoLinkedLists {

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
    * 建立一个哈希表，用来存储A链表的所有地址
    * 时间复杂度：O(m+n)
    * 空间复杂度：O(m)
    * */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<String> aSet = new HashSet<>();
        ListNode p = headA;
        while (p != null) {
            aSet.add(p.toString());
            p = p.next;
        }
        p = headB;
        while (p != null) {
            if (aSet.contains(p.toString())) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    /*
    * 双指针解法
    * 时间复杂度：O(m+n)
    * 空间复杂度：O(1)
    * */
    public ListNode getIntersectionNodeByLeetcode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
//        ListNode lastA = null;
//        ListNode lastB = null;
//        while (pA != null && pB != null) {
//            if (pA == pB && lastA == lastB) { // 需要考虑有一条链只有一个元素的情况
//                return pA;
//            }
//            if (lastA != null && lastB != null && lastA != lastB) { // 记录末尾节点，若末结点不同，则比不相交
//                return null;
//            }
//            if (pA.next == null) {
//                lastA = pA;
//                pA = headB;
//            }
//            pA = pA.next;
//            if (pB.next == null) {
//                lastB = pB;
//                pB = headA;
//            }
//            pB = pB.next;
//        }
        while (pA != pB) { // 最终pA和pB相交，或同时为null
            pA = (pA == null) ? headB : pA.next;
            pB = (pB == null) ? headA : pB.next;
        }
        return pA;
    }

    public static void main(String[] args) {
        IntersectionOfTwoLinkedLists temple = new IntersectionOfTwoLinkedLists();
        System.out.println();
    }
}
