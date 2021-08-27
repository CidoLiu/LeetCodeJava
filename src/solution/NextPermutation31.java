package solution;

import java.util.Arrays;

public class NextPermutation31 {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j > i && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        System.out.println(Arrays.toString(nums));
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public void reverse(int[] nums, int n) {
        int i = n;
        int j = nums.length - 1;
        while (i <= j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        NextPermutation31 test = new NextPermutation31();
        int[] nums1 = {3, 2, 1};
        int[] nums2 = {5, 1, 1};
        test.nextPermutation(nums2);
        System.out.println(Arrays.toString(nums2));
    }
}
