package solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @id 101
 * @author dongjin
 * @date 2020/10/25 12:00
 */
public class SymmetricTree {

    // Definition for a binary tree node.
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /*
    * 官方递归解法
    * 时间复杂度：O(n)
    * 空间复杂度：O(n)
    * */
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    private boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }

    /*
    * 迭代
    * */
    public boolean isSymmetricByIteration(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if (node1 == null && node2 == null) {
                continue;
            }
            if (node1 == null || node2 == null) {
                return false;
            }
            if (node1.val != node2.val) {
                return false;
            }
            queue.offer(node1.left); // 错位入队，使得相邻的值相等（在满足对称的情况下）
            queue.offer(node2.right);

            queue.offer(node1.right);
            queue.offer(node2.left);
        }
        return true;
    }

    public static void main(String[] args) {
        SymmetricTree temple = new SymmetricTree();
        System.out.println();
    }
}
