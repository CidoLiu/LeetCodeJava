package solution;

/**
 * @id 88
 * @author dongjin
 * @date 2020/10/23 16:00
 */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = nums1.length - 1;
        int p1 = m - 1;
        int p2 = n - 1;
        while ( p1 >= 0 && p2 >= 0) {
            if (nums1[p1] <= nums2[p2]) {
                nums1[p] = nums2[p2];
                p--;
                p2--;
                continue;
            } else {
                nums1[p] = nums1[p1];
                p--;
                p1--;
                continue;
            }
        }
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }

    public static void main(String[] args) {
        MergeSortedArray temple = new MergeSortedArray();
        int[] nums1 = {0};
        int m = 0;
        int[] nums2 = {2};
        int n = 1;
        temple.merge(nums1, m, nums2, n);
        for (int item: nums1) {
            System.out.println(item);
        }
    }
}
