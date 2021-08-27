package solution;

import java.net.PortUnreachableException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @id 112
 * @author dongjin
 * @date 2020/10/26 14:30
 */
public class PathSum {


     // Definition for a binary tree node.
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;

         TreeNode(int x) {
             val = x;
         }
     }

     /*
     * 自己写的递归算法（深度优先）
     * 时间复杂度：O(N)，N为树的节点数
     * 空间复杂度：O(H)，H为树的高度；平均情况下为O(logN)
     * */
    public boolean hasPathSum(TreeNode root, int sum) {
//        if (root == null) {
//            if (sum == 0) { // 测试用例([], 0)会报错
//                return true;
//            } else {
//                return false;
//            }
//        }
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    /*
    * 广度优先搜索
    * 时间复杂度：O(N)
    * 空间复杂度：O(N)
    * */
    public boolean hasPathSumByBFS(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queueNode = new LinkedList<>();
        Queue<Integer> queueValue = new LinkedList<>();
        queueNode.offer(root);
        queueValue.offer(root.val);
        while (!queueNode.isEmpty()) {
            TreeNode node = queueNode.poll();
            Integer temp = queueValue.poll();
            if (node.left == null && node.right == null) {
                if (temp == sum) {
                    return true;
                }
                continue;
            }
            if (node.left != null) {
                queueNode.offer(node.left);
                queueValue.offer(temp + node.left.val);
            }
            if (node.right != null) {
                queueNode.offer(node.right);
                queueValue.offer(temp + node.right.val);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        PathSum temple = new PathSum();
        System.out.println();
    }
}
