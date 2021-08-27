package solution;

/**
 * @id 204
 * @author dongjin
 * @date 2020/11/8 15:07
 */
public class CountPrimes {

    /*
    * 超出时间限制
    * 时间复杂度：O(n^2)
    * */
    public int countPrimes(int n) {
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (isPrimes(i)) {
                System.out.println(i);
                count++;
            }
        }
        return count;
    }

    private boolean isPrimes(int x) {
        if (x == 2) { // 2是特殊的偶数，需要特殊处理
            return true;
        }
        if (x == 1 || x % 2 == 0) { // 对偶数进行剪枝
            return false;
        }
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    /*
    * 厄拉多塞筛法
    * */
    public int countPrimesLeetcode(int n) {
        if (n < 2) {
            return 0;
        }
        boolean[] bits = new boolean[n+1]; // 定义一个位图，是质数为false（默认），不是质数则为true
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!bits[i]) {
                count++;
                for (int j = i + i; j < bits.length; j += i) {
                    bits[j] = true; // 若x为质数，则x的倍数不为质数
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountPrimes temple = new CountPrimes();
//        System.out.println(temple.isPrimes(4));
        System.out.println(temple.countPrimesLeetcode(10));
    }
}
