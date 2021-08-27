package solution;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

/**
 * @id 111
 * @author dongjin
 * @date 2020/10/26 13:30
 */
public class MinimumDepthOfBinaryTree {

    // Definition for a binary tree node.
    private class TreeNode {
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
    * 深度优先搜索
    * 时间复杂度：O(N)，其中 N 是树的节点数。对每个节点访问一次。
    * 空间复杂度：O(H)，其中 H 是树的高度
    * */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
//        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        int minDepth = Integer.MAX_VALUE; // 若左子树为空，且右子树不为空，那么最小的Depth是右子树的Depth，而不是左子树的0
        if (root.left != null) {
            minDepth = Math.min(minDepth(root.left), minDepth);
        }
        if (root.right != null) {
            minDepth = Math.min(minDepth(root.right), minDepth);
        }
        return minDepth + 1;
    }

    /*
    * 广度优先搜索
    * 时间复杂度：O(N)，其中 N 是树的节点数。
    * 空间复杂度：O(N)
    * */
    public int minDepthByBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
        MinimumDepthOfBinaryTree temple = new MinimumDepthOfBinaryTree();
        System.out.println();
    }
}
