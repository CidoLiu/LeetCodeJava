package solution;

/**
 * @author dongjin
 * @date 2020/11/7 19:00
 */
public class FactorialTrailingZeroes {

    /*
    * 暴力解法，先使用递归求得阶乘值
    * 注意：计算阶乘时可能溢出int，改成long后仍然可能溢出，因此结果错误
    * */
    public int trailingZeroes(int n) {
        long ans = factorial(n);
        System.out.println(ans);
        int count = 0;
        while (true) {
            if (ans % 10 == 0) {
                count++;
            } else {
                break;
            }
            ans /= 10;
        }
        return count;
    }

    private long factorial(long n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    /*
    * 计算阶乘中因子5的个数
    * */
    public int trailingZeroesByFive(int n) {
        int count = 0;
        while (n >= 5) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }

    public static void main(String[] args) {
        FactorialTrailingZeroes temple = new FactorialTrailingZeroes();
        System.out.println(temple.trailingZeroes(5));
    }
}
