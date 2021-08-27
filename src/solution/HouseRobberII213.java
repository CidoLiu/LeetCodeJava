package solution;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author dongjin
 * @id
 * @date 2021/2/18 12:00
 */
public class HouseRobberII213 {

//    public int rob(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//        if (nums.length == 1) {
//            return nums[0];
//        }
//        return Math.max(dp(Arrays.copyOfRange(nums, 0, nums.length - 1)
//        ), dp(Arrays.copyOfRange(nums, 1, nums.length)));
//    }
//
//    public int dp(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//        if (nums.length == 1) {
//            return nums[0];
//        }
//        int first = nums[0];
//        int second = Math.max(nums[0], nums[1]);
//        for (int i = 2; i < nums.length; i++) {
//            int oldSecond = second;
//            second = Math.max(first + nums[i], oldSecond);
//            first = oldSecond;
//        }
//        return second;
//    }

    class Solution {
        public int rob(int[] nums) {
            if(nums.length == 0) return 0;
            if(nums.length == 1) return nums[0];
            return Math.max(myRob(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                    myRob(Arrays.copyOfRange(nums, 1, nums.length)));
        }

        private int myRob(int[] nums) {
            int pre = 0, cur = 0, tmp;
            for(int num : nums) {
                tmp = cur;
                cur = Math.max(pre + num, cur);
                pre = tmp;
            }
            return cur;
        }
    }

    public static void main(String[] args) {
        HouseRobberII213 temple = new HouseRobberII213();
        System.out.println();
    }
}
