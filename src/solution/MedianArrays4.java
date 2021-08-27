package solution;

/**
 * @author dongjin
 * @id 4
 * @date 2021/3/11 16:00
 */
public class MedianArrays4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        // 特殊情况处理
        if (m == 0 && n == 0) {
            return 0.0D;
        }
        if (m == 0) {
            if (n % 2 != 0) {
                return nums2[n / 2];
            } else {
                return (double) (nums2[n / 2 - 1] + nums2[n / 2]) / 2;
            }
        }
        if (n == 0) {
            if (m % 2 != 0) {
                return nums1[m / 2];
            } else {
                return (double) (nums1[m / 2 - 1] + nums1[m / 2]) / 2;
            }
        }
        // 合并两个数组
        int num = m + n;
        int[] merge = new int[num];
        int counter = 0;
        int i = 0;
        int j = 0;
        while (counter < num) {
            while (i < m && j < n) {
                if (nums1[i] < nums2[j]) {
                    merge[counter++] = nums1[i++];
                } else {
                    merge[counter++] = nums2[j++];
                }
            }
            if (i < m) {
                merge[counter++] = nums1[i++];
            }
            if (j < n) {
                merge[counter++] = nums2[j++];
            }
        }
//        for (int k = 0; k < num; k++) {
//            System.out.print(merge[k]+ " ");
//        }
//        System.out.println();
        // 计算中位数
        if (num % 2 != 0) {
            return merge[num / 2];
        } else {
            return (double) (merge[num / 2 - 1] + merge[num / 2]) /2;
        }
    }

    public static void main(String[] args) {
        MedianArrays4 temple = new MedianArrays4();
        System.out.println(temple.findMedianSortedArrays(new int[] {1,2}, new int[] {3,4}));
    }
}
