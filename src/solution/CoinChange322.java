package solution;

import java.util.Arrays;

/**
 * @author dongjin
 * @id 322
 * @date 2021/3/12 12:00
 */
public class CoinChange322 {

    // 动态规划
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[max];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        CoinChange322 temple = new CoinChange322();
        System.out.println();
    }
}
