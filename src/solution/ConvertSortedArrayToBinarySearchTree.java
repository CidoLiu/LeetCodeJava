package solution;

/**
 * @id 108
 * @author dongjin
 * @date 2020/10/25 13:45
 */
public class ConvertSortedArrayToBinarySearchTree {

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
    * 递归求解
    * 因为数组为有序数组，因此每次使用中间元素作为根节点
    * 时间复杂度：O(n)
    * 空间复杂度：O(logn)，空间复杂度取决于递归栈的深度
    * */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return bfs(nums, 0, nums.length - 1);
    }

    private TreeNode bfs(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }
        int middle = low + (high - low) / 2;
        TreeNode node = new TreeNode(nums[middle]);
        node.left = bfs(nums, low, middle - 1);
        node.right = bfs(nums, middle + 1, high);
        return node;
    }

    public static void main(String[] args) {
        ConvertSortedArrayToBinarySearchTree temple = new ConvertSortedArrayToBinarySearchTree();
        System.out.println();
    }
}
