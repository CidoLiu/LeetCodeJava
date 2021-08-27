package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum15 {
    /**
     * 先排序，然后在一重循环内使用左右双指针
     * 暂时没有解决{0, 0, 0, 0}的问题
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(N)
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
//        System.out.println(Arrays.toString(nums));
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    lists.add(list);
//                    System.out.println(list);
                    left++;
                    right--;
                    // 结果去重
                    while (left < right && left - 1 >= 0 && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && right + 1 < nums.length && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum < 0) {
                    // 不等于0则不用考虑去重，因为如果left-1 === left，那么新的指向也不会使得sum=0
                    left++;
                } else {
                    right--;
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        int[] nums2 = {0, 0, 0, 0};
        int[] nums3 = {-2, 0, 0, 2, 2};
        System.out.println(threeSum(nums2));
    }
}
