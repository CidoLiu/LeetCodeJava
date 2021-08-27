package solution;

import java.util.Arrays;

/**
 * @id 198
 * @author dongjin
 * @date 2020/11/8 14:16
 */
public class HouseRobber {

    /*
    * 简单的认为取不相邻的只有2种情况，答案错误
    * 用例：[2,1,1,2]，答案应该是4
    * */
    public int robError(int[] nums) {
        int sumI = 0;
        int sumJ = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sumI += nums[i];
        }
        for (int j = 1; j < nums.length; j += 2) {
            sumJ += nums[j];
        }
        return Math.max(sumI, sumJ);
    }

    /*
    * 递归解法，超出时间限制，测试用例56/69
    * 时间复杂度：O(nlogn)
    * 空间复杂度：O(1)
    * */
    public int rob(int[] nums) {
        if (nums == null || nums.length ==0) {
            return 0;
        }
        return rob(nums, 0);
    }

    private int rob(int[] nums, int i) {
//        System.out.println(i);
        if (i == nums.length -1) {
            return nums[i];
        }
        if (i == nums.length -2) {
            return Math.max(nums[i], nums[i + 1]);
        }
        return Math.max(nums[i] + rob(nums, i + 2), rob(nums, i + 1));
    }

    /**
     * 动态规划
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param nums
     * @return
     */
    public int robDP(int[] nums) {
        if (nums == null || nums.length ==0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        // 子问题：
        // dp(k) = 偷 [0..k] 房间中的最大金额

        // dp(0) = 0
        // dp(1) = max(nums[0], nums[1])
        // dp(k) = max(dp(k-1), dp[k-2] + nums[k])

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int k = 2; k < nums.length; k++) {
            dp[k] = Math.max(dp[k - 1], nums[k] + dp[k - 2]);
        }
//        System.out.println(Arrays.toString(dp));
        return dp[nums.length - 1];
    }

    /**
     * 动态规划，滚动数组，节省空间
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    public int robDPRoll(int[] nums) {
        if (nums == null || nums.length ==0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int old_second = second;
            second = Math.max(second, first + nums[i]);
            first = old_second;
        }
        return second;
    }


    public static void main(String[] args) {
        HouseRobber temple = new HouseRobber();
        System.out.println(temple.robDPRoll(new int[] {1,2,3,1}));
    }
}
