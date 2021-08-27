package solution;

/**
 * @author dongjin
 * @date 2020/10/22 16:20
 */
public class MaximumSubarray {

    /*
    * 贪心算法，核心思想：若之前的和小于0，则丢弃之前的和，重新开始计算。
    * 时间复杂度：O(n)
    * 空间复杂度：O(1)
    * */
    public int maxSubArrayGreed(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int maxSum = nums[0];
        int nowSum = nums[0];
        int preSum = 0;
        for (int x: nums) {
            if (preSum < 0) {
                preSum = 0;
            }
            nowSum = preSum + x;
            if (nowSum >= maxSum) {
                maxSum = nowSum;
            }
            preSum = nowSum;
        }
        return maxSum;
    }

    /*
     * 动态规划
     * 转移方程：f(i) = max(f(i-1)+ai, ai)
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * */
    public int maxSubArray(int[] nums) {
        int pre = 0;
        int maxSum = nums[0];
        for (int x: nums) {
            pre = Math.max(pre + x, x);
            maxSum = Math.max(maxSum, pre);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MaximumSubarray temple = new MaximumSubarray();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(temple.maxSubArray(nums));
    }
}
