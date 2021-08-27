package solution;

/**
 * @id 121
 * @author dongjin
 * @date 2020/10/26 16:22
 */
public class BestTimeToBuyAndSellStock {

    /*
    * 暴力解法
    * 时间复杂度：O(n^2)
    * */
    public int maxProfitForce(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            }
        }
        return maxProfit;
    }

    /*
    * 题解：单次遍历
    * 时间复杂度：O(n)
    * */
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int maxProfit = 0;
        int minBuy = prices[0];
        for (int price: prices) {
            minBuy = Math.min(minBuy, price);
            maxProfit = Math.max(maxProfit, price - minBuy);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock temple = new BestTimeToBuyAndSellStock();
        System.out.println(temple.maxProfit(new int[]{}));
    }
}
