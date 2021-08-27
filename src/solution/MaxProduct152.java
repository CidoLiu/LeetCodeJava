package solution;

/**
 * @author dongjin
 * @id 152
 * @date 2021/2/1 15:48
 */
public class MaxProduct152 {

    /**
     * 动态规划
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int length = nums.length;
        int[] max = new int[length];
        int[] min = new int[length];
        System.arraycopy(nums, 0, max, 0, length);
        System.arraycopy(nums, 0, min, 0, length);
        for(int i = 1; i < length; i++) {
            max[i] = Math.max(max[i-1]*nums[i], Math.max(min[i-1]*nums[i], nums[i]));
            min[i] = Math.min(max[i-1]*nums[i], Math.min(min[i-1]*nums[i], nums[i]));
        }
        int ans = max[0];
        for(int i =1; i < length; i++) {
            if(ans < max[i]) {
                ans = max[i];
            }
        }
        return ans;
    }

    public int maxProductRoll(int[] nums) {
        int maxF = nums[0];
        int minF = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
//            System.out.println(maxF+" "+minF);
            int oldMaxF = maxF;
            int oldMinF = minF;
            maxF = Math.max(oldMaxF * nums[i], Math.max(oldMinF * nums[i], nums[i]));
            minF = Math.min(oldMaxF * nums[i], Math.min(oldMinF * nums[i], nums[i]));
            if (Math.max(maxF, minF) > ans) {
                ans = Math.max(maxF, minF);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxProduct152 temple = new MaxProduct152();
        System.out.println(temple.maxProductRoll(new int[]{2, 3, -2, 4}));
    }
}
