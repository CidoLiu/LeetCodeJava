package solution;

public class Search33 {
    /**
     * 分割为两个有序数组，然后分别进行二分查找
     * 时间复杂度：寻找分割点为O(n)
     * 可以优化
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int split = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                split = i;
            }
        }
        int ans1 = search(nums, target, 0, split);
        if (ans1 != -1) {
            return ans1;
        }
        int ans2 = search(nums, target, split+1, nums.length -1);
        if (ans2 != -1) {
            return ans2;
        }
        return -1;
    }

    public int search(int[] nums, int target, int left, int right) {
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid-1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
