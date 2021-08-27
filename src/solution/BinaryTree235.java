package solution;

import com.sun.source.tree.Tree;

import java.util.Stack;

/**
 * @author dongjin
 * @id 235
 * @date 2020/11/9 16:37
 */
public class BinaryTree235 {

    // Definition for a binary tree node.
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        System.out.println(root.val);
//        System.out.println(Math.max(p.val, q.val) >= root.val && Math.min(p.val, q.val) <= root.val);
        if (Math.max(p.val, q.val) >= root.val && Math.min(p.val, q.val) <= root.val) {
            return root;
        } else if (p.val < root.val && root.left != null) {
            return lowestCommonAncestor(root.left, p, q);
        } else if(p.val > root.val && root.right != null) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return null;
    }

    public static void main(String[] args) {
        BinaryTree235 temple = new BinaryTree235();
        System.out.println();
    }
}
