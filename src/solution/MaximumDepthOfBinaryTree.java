package solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @id 104
 * @author dongjin
 * @date 2020/10/25 12:15
 */
public class MaximumDepthOfBinaryTree {

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
    * 官方递归解法，还可以使用广度优先搜索
    * 时间复杂度：O(n)
    * 空间复杂度：O(树的高度)
    * */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /*
    * 广度优先搜索
    * 参照107的答案，默写出来的广度优先搜索
    * 时间复杂度：O(n)
    * 空间复杂度：最坏为O(n)
    * */
    public int maxDepthByBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                TreeNode left = node.left;
                TreeNode right = node.right;
                if (left != null) {
                    queue.offer(left);
                }
                if (right != null) {
                    queue.offer(right);
                }
            }
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
        MaximumDepthOfBinaryTree temple = new MaximumDepthOfBinaryTree();
        System.out.println();
    }
}
