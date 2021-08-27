package solution;

/**
 * @id 70
 * @author dongjin
 * @date 2020/10/23 13:40
 */
public class ClimbingStairs {

    /*
    * 排列组合法
    * 提交后超时
    * */
    public int climbStairs(int n) {
        int ans = 0;
        for (int i = 0; i <= n / 2; i++) {
//            System.out.println(ans);
            ans += comb(i + n - 2 * i, i); // i + n - 2 * i为当前数列总长度，i表示2的个数
        }
        return ans;
    }

    /*
    * 递归计算组合数
    * 从m中取n个元素的取法
    * */
    private static long comb(int m,int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return m;
        if (n > m / 2)
            return comb(m, m - n);
        if (n > 1)
            // 从m个球中取出n个球可以分成两种情况相加，从m个球中取出一个球，如果它属于n，还需要从m-1中取出n-1个球；如果它不属于n，则需要从m-1中取出n个球
            return comb(m - 1, n - 1) + comb(m - 1, n);
        return -1;
    }

    /*
    * 动态规划
    * 递推公式：f(n) = f(n-1) + f(n-2)
    *  1 2 3 5 8
    * 一个典型的斐波那契数列问题
    * 时间复杂度：O(n)
    * 空间复杂度：O(1)
    * */
    private int climbStairsLeetcode(int n) {
        // p q r
        int p = 0;
        int q = 0;
        int r = 1;
        for (int i = 0; i < n; i++){
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

    public static void main(String[] args) {
        ClimbingStairs temple = new ClimbingStairs();
//        System.out.println(comb(3,1));
//        System.out.println(comb(3,2));
        System.out.println(temple.climbStairsLeetcode(45));
    }
}
