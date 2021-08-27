package solution;

/**
 * @author dongjin
 * @id 110
 * @date 2020/10/25 14:14
 */
public class BalancedBinaryTree {

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

//    public boolean isBalanced(TreeNode root) {
//        if (root == null) {
//            return true;
//        }
//        return isBalanced(root, root);
//    }
//
//    private boolean isBalanced(TreeNode p, TreeNode q) {
//        if (p == null && q == null) {
//            return true;
//        }
//        if (p == null && q.left == null && q.right == null) {
//            return true;
//        }
//        if (q == null && p.left == null && p.right == null) {
//            return true;
//        }
//        return isBalanced(p.left, p.right) && isBalanced(q.left, q.right);
//    }

    /*
    * 官方题解：自顶向下递归，需要重复计算多次子树的高度
    * 时间复杂度：O(n ^ 2)
    * */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(treeHeight(root.left) - treeHeight(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    /** 求树的高度
     * @param node 树的根节点
     * @return 树的高度
     */
    private int treeHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(treeHeight(node.left), treeHeight(node.right)) + 1;
    }

    /*
    * 官方题解：自底向上的递归
    * */
    public boolean isBalancedByDownToUp(TreeNode root) {
        return treeHeightByDownToUp(root) >= 0;
    }


    /** 若树是平衡树，则返回树的高度；否则返回-1
     * @param node 树的根节点
     * @return -1 or 树的高度
     */
    private int treeHeightByDownToUp(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = treeHeightByDownToUp(node.left);
        int rightHeight = treeHeightByDownToUp(node.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        BalancedBinaryTree temple = new BalancedBinaryTree();
        System.out.println();
    }
}
