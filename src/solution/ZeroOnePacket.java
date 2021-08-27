package solution;

public class ZeroOnePacket {

    /**
     * @param V 背包容量
     * @param N 物品数量
     * @param weight 物品重量
     * @param value 物品价值
     * @return
     */
    public static int zeorOnePacket(int V, int N, int[] weight, int[] value) {
        //dp[i][j]表示前i件物品放入一个重量为m的背包可以获得的最大价值
        int[][] dp = new int[N+1][V+1];
        for (int i=0; i <= N; i++) {
            for (int j=0; j <= V; j++) {
                if(i==0||j==0) {
                    // 处理边界
                    dp[i][j] = 0;
                } else {
                    // 因为有边界，所以当前处理的物品重量为weight[i-1]，价值为value[i-1]
                    if(j>=weight[i-1]) {
                        dp[i][j] = Math.max(dp[i-1][j-weight[i-1]]+value[i-1], dp[i-1][j]);
                    } else {
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }
        show(dp);
        return dp[N][V];
    }

    static void show(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] weight = {3, 4, 5};
        int[] value = {4, 5, 6};
        System.out.println(ZeroOnePacket.zeorOnePacket(10,3, weight, value));
    }

}
