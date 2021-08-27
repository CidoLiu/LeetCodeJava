package solution;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Test {

    Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quickSelect(int[] a, int l, int r, int index) {
        int p = randomSelect(a, l, r);
        if (p == index) {
            return a[p];
        }
        return p < index ? quickSelect(a, p+1, r, index) : quickSelect(a, l, p-1, index);
    }

    int randomSelect(int[] a, int l, int r) {
        int x = random.nextInt(r - l + 1) + l;
        swap(a, x, r);
        return quickSwap(a, l, r);
    }

    int quickSwap(int[] a, int l, int r) {
        int x = a[r];
        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (a[j] <= x) {
                swap(a, ++i, j);
            }
        }
        swap(a, i + 1, r);
        return i + 1;
    }

    void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        Test test = new Test();
        int[] a = {3,2,1,5,6,4};
        System.out.println(test.findKthLargest(a, 2));
    }
}
