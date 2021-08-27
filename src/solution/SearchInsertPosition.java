package solution;

/**
 * @author dongjin
 * @date 2020/10/22 15:00
 */
public class SearchInsertPosition {

    /*
    * 二分搜索
    * 时间复杂度：O(logn)
    * 空间复杂度：O(1)
    * */
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int ans = nums.length;
        while (left <= right) {
            int middle = left + (right - left) / 2; // 避免溢出
            if (target <= nums[middle]) {
                ans = middle;
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        SearchInsertPosition temple = new SearchInsertPosition();
        int[] nums = {1,3,5,6};
        int target = 7;
        System.out.println(temple.searchInsert(nums, target));
    }
}
