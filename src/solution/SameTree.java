package solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @id 100
 * @author dongjin
 * @date 2020/10/23 17:00
 */
public class SameTree {

    static private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /*
    * 递归深度优先搜索
    * 时间复杂度：O(min(n, m))
    * 空间复杂度：O(min(n, m))
    * */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p != null && q != null) {
            if (p.val != q.val){
                return false;
            }
        } else if (p == null && q == null) {
            return true;
        } else {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    /*
    * BFS
    * 时间复杂度：O(min(n, m))
    * 空间复杂度：O(min(n, m))
    * */
    public boolean isSameTreeByBFS(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }
        Queue<TreeNode> queueP = new LinkedList<TreeNode>();
        Queue<TreeNode> queueQ = new LinkedList<TreeNode>();
        queueP.offer(p);
        queueQ.offer(q);
        while (!queueP.isEmpty() && !queueQ.isEmpty()) {
            TreeNode nodeP = queueP.poll();
            TreeNode nodeQ = queueQ.poll();
            if (nodeP.val != nodeQ.val) {
                return false;
            }
            TreeNode leftP = nodeP.left;
            TreeNode rightP = nodeP.right;
            TreeNode leftQ = nodeQ.left;
            TreeNode rightQ = nodeQ.right;
            if (leftP == null ^ leftQ == null) { // 异或运算，不同时为空
                return false;
            }
            if (rightP == null ^ rightQ == null) {
                return false;
            }
            if (leftP != null) {
                queueP.offer(leftP);
            }
            if (rightP != null) {
                queueP.offer(rightP);
            }
            if (leftQ != null) {
                queueQ.offer(leftQ);
            }
            if (rightQ != null) {
                queueQ.offer(rightQ);
            }
        }
        return queueP.isEmpty() && queueQ.isEmpty();
    }

    public static void main(String[] args) {
        SameTree temple = new SameTree();
        System.out.println();
    }
}
