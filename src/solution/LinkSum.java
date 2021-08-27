package solution;

import java.util.List;

/**
 * @author dongjin
 * @id 2
 * @date 2021/3/16 15:47
 */
public class LinkSum {

    private static class ListNode {
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

    /**
     * 链表相加，先相加，再处理进位，中间态节点值可能溢出（严格限制各位情况下）
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode ans = new ListNode(0);
        ListNode w = ans;
        ListNode p = l1;
        ListNode q = l2;
        // 逐个求和
        while (p != null && q != null) {
            int temp = p.val + q.val;
            w.next = new ListNode(temp);
            w = w.next;
            p = p.next;
            q = q.next;
        }
        if (p != null) {
            w.next = p;
        }
        if (q != null) {
            w.next = q;
        }
        w = ans;
        // 处理进位
        while (w != null) {
            if (w.val >= 10) {
                w.val -= 10;
                if (w.next != null) {
                    w.next.val += 1;
                } else {
                    w.next = new ListNode(1);
                }
            }
            w = w.next;
        }
        return ans.next;
    }

    /**
     * 链表相加，只遍历一次
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;
        ListNode headPre = new ListNode(0);
        ListNode w = headPre;
        while(p != null || q != null) {
            if (w.next == null) {
                w.next = new ListNode(0);
            }
            w = w.next;
            int temp = 0;
            if (q != null) {
                temp += q.val;
            }
            if (p != null) {
                temp += p.val;
            }
            if (w != null) {
                temp += w.val;
            }
            // System.out.println(temp);
            if (temp >= 10) {
                w.val = temp - 10;
                w.next = new ListNode(1);
            } else {
                w.val = temp;
            }
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        return headPre.next;
    }

    private static void showList(ListNode listNode) {
        ListNode p = listNode;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode p = l1;
        p.next = new ListNode(4);
        p = p.next;
        p.next = new ListNode(3);
        showList(l1);
        ListNode l2 = new ListNode(5);
        p = l2;
        p.next = new ListNode(6);
        p = p.next;
        p.next = new ListNode(4);
        showList(l2);
        ListNode ans = addTwoNumbers(l1, l2);
        showList(ans);
    }
}
