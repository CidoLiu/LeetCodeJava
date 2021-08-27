package solution;

import javax.xml.transform.stax.StAXResult;
import java.util.Arrays;

/**
 * @id 231
 * @author dongjin
 * @date 2020/11/9 11:14
 */
public class PowerOfTwo {

    /*
    * 时间复杂度：O(sqrt(n)*logn)
    * */
    public boolean isPowerOfTwo(int n) {
        int s = (int)Math.sqrt(n) + 1;
//        System.out.println(Math.sqrt(n));
        long[] ary = new long[s + 1];
        for (int i = 0; i <= s; i++) {
            ary[i] = (long) Math.pow(2, i);
        }
//        System.out.println(Arrays.toString(ary));
        return find(ary, n);
    }

    /*
    * 二分查找
    * */
    private boolean find(long[] ary, int tag) {
        int left = 0;
        int right = ary.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (ary[mid] == tag) {
                return true;
            } else if (ary[mid] < tag) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    /*
    * 时间复杂度：O(1)
    * */
    public boolean isPowerOfTwoBinary(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        PowerOfTwo temple = new PowerOfTwo();
        System.out.println(temple.isPowerOfTwoBinary(1024));
    }
}
