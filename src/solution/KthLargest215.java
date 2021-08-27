package solution;

import java.util.Random;

/**
 * @id 215
 * @author dongjin
 * @date 2021/2/18 12:00
 */
public class KthLargest215 {



    public static void main(String[] args) {
        KthLargest215 temple = new KthLargest215();
        System.out.println();
    }
}


// 基于快速排序的快速选择算法
class Solution {
    Random random = new Random();

    // 在未排序的数组中找到第 k 个最大的元素。
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    /**
     * 快速选择算法，找到无序数组的第K大的元素
     * @param a 无序数组
     * @param l 数组左索引
     * @param r 数组右索引
     * @param index 目标位置
     * @return 目标位置的元素
     */
    public int quickSelect(int[] a, int l, int r, int index) {
        int q = randomSelect(a, l, r);
        if (q == index) {
            return a[q];
        } else {
            return q < index ? quickSelect(a, q + 1, r, index) : quickSelect(a, l, q - 1, index);
        }
    }

    public int randomSelect(int[] a, int l, int r) {
        int i = random.nextInt(r - l + 1) + l;
        swap(a, i, r);
        return partition(a, l, r);
    }

    /**
     * 以r为flag，对数组a中l到r进行快速排序
     * @param a
     * @param l
     * @param r
     * @return
     */
    public int partition(int[] a, int l, int r) {
        int x = a[r];
        int i = l - 1;
        for (int j = l; j < r; ++j) {
            if (a[j] <= x) {
                swap(a, ++i, j);
            }
        }
        swap(a, i + 1, r);
        return i + 1;
    }

    /**
     * 交换数组中两个元素的值
     * @param a
     * @param i
     * @param j
     */
    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}