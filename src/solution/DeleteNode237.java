package solution;

/**
 * @id 237
 * @author dongjin
 * @date 2020/11/9 19:47
 */
public class DeleteNode237 {

    // Definition for singly-linked list.
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        DeleteNode237 temple = new DeleteNode237();
        System.out.println();
    }
}
