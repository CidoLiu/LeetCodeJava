package solution;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @id 107
 * @author dongjin
 * @date 2020/10/25 12:40
 */
public class BinaryTreeLevelOrderTraversalII {

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
    * 官方题解：广度优先搜索
    * 时间复杂度：O(n)
    * 空间复杂度：O(n)
    * */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ansList = new LinkedList<List<Integer>>();
        if (root == null) {
            return ansList;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                list.add(node.val);
                TreeNode left = node.left;
                TreeNode right = node.right;
                if (left != null) {
                    queue.offer(left);
                }
                if (right != null) {
                    queue.offer(right);
                }
            }
            ansList.add(0, list);
        }
        return ansList;
    }

    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversalII temple = new BinaryTreeLevelOrderTraversalII();
        System.out.println();
    }
}
