package solution;

/**
 * @author dongjin
 * @id 226
 * @date 2020/11/9 10:19
 */
public class InvertBinaryTree {

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
    * 我自己做出来了，可以进Google了吗 QAQ
    * 时间复杂度：O(n)
    * 空间复杂度：平均O(logn)，最坏O(n)
    * */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }

    public static void main(String[] args) {
        InvertBinaryTree temple = new InvertBinaryTree();
        System.out.println();
    }
}
