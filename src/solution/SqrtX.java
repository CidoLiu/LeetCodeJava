package solution;

/**
 * @author dongjin
 * @date 2020/10/23 12:51
 */
public class SqrtX {

    public int mySqrt(int x) {
        return (int)Math.sqrt(x);
    }

    /*
    * 二分查找
    * 时间复杂度：O(log x)
    * 利用ans来记录每次平方小于等于x的正整数
    * */
    public int mySqrtLeetcodeByBinarySearch(int x) {
        int left = 0;
        int right = x;
        int ans = -1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if ((long)middle * middle > x) { // middle * middle 的计算结果可能溢出为负数，从而导致错误结果
                right = middle - 1;
            } else {
                ans = middle;
                left = middle + 1;
            }
        }
        return ans;
    }

    /*
    * 牛顿迭代法
    * */
    public int mySqrtLeetcodeByNewtonMethod(int x) {
        if (x == 0) {
            return 0;
        }
        double ans = -1;
        double xi = x;
        while (true) {
            ans = 0.5 * (x / xi + xi);
            if (xi - ans < 1e-7) {
                break;
            }
            xi = ans;
        }
        return (int)ans;
    }

    public static void main(String[] args) {
        SqrtX temple = new SqrtX();
        System.out.println(temple.mySqrtLeetcodeByBinarySearch(2147395599));
    }
}
