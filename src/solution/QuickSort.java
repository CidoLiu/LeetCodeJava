package solution;

import java.util.Arrays;
import java.util.Random;

/**
 * 快速排序
 *
 * @author dongjin
 * @date 2021/3/2 15:11
 */
public class QuickSort {

    Random random = new Random();

    void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    void quickSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int x = random.nextInt(r - l + 1) + l;
        swap(nums, r, x);
        int flag = partition(nums, l, r);
        quickSort(nums, l, flag - 1);
        quickSort(nums, flag + 1, r);
    }

    int partition(int[] nums, int l, int r) {
        int x = nums[r];
        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (nums[j] <= x) {
                swap(nums, j, ++i);
            }
        }
        swap(nums, r, i + 1);
        return i + 1;
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        QuickSort temple = new QuickSort();
        int[] a = {3,2,1,5,6,4};
        temple.quickSort(a);
        System.out.println(Arrays.toString(a));
    }
}
