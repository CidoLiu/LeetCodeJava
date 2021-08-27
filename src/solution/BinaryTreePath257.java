package solution;

import java.util.*;

/**
 * @id 257
 * @author dongjin
 * @date 2020/11/9 20:12
 */
public class BinaryTreePath257 {

    // Definition for a binary tree node.
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 深度优先搜索（递归）
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n^2)
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<String>();
        constructPaths(root, "", paths);
        return paths;
    }

    public void constructPaths(TreeNode root, String path, List<String> paths) {
        if (root != null) {
            StringBuilder pathSB = new StringBuilder(path);
            pathSB.append(Integer.toString(root.val));
            if (root.left == null && root.right == null) {
                paths.add(pathSB.toString());
            } else {
                pathSB.append("->");
                constructPaths(root.left, pathSB.toString(), paths);
                constructPaths(root.right, pathSB.toString(), paths);
            }
        }
    }

    /**
     * 广度优先搜索
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n^2)
     * @param root
     * @return
     */
    public List<String> binaryTreePathsBFS(TreeNode root) {
        List<String> paths = new ArrayList<String>();
        if (root == null) {
            return paths;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        Queue<String> pathQueue = new LinkedList<String>();

        nodeQueue.offer(root);
        pathQueue.offer(Integer.toString(root.val));

        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            String path = pathQueue.poll();

            if (node.left == null && node.right == null) {
                paths.add(path);
            } else {
                if (node.left != null) {
                    nodeQueue.add(node.left);
                    pathQueue.add(new StringBuilder(path).append("->").append(Integer.toString(node.left.val)).toString());
                }
                if (node.right != null) {
                    nodeQueue.add(node.right);
                    pathQueue.add(new StringBuilder(path).append("->").append(Integer.toString(node.right.val)).toString());
                }
            }
        }
        return paths;
    }


    public static void main(String[] args) {
        BinaryTreePath257 temple = new BinaryTreePath257();
        System.out.println();
    }
}
