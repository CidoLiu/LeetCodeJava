package solution;

/**
 * @id 122
 * @author dongjin
 * @date 2020/10/26 17:00
 */
public class BestTimeToBuyAndSellStockII {

    /*
    * 寻找每次出售和购买的最优值
    * 当明天的价格高于今天时，选择出售；出售后，购买和卖出的价格都初始化为明天的价格。
    * 当当前价格低于购买价格时，取当前价格为新的购买价格。
    * 时间复杂度：O(n)
    * */
    public int maxProfit(int[] prices) {
        if (prices.length <= 1){
            return 0;
        }
        int sumProfit = 0;
        int tempBuy = prices[0];
        int tempSell = prices[1];
        for (int i = 0; i < prices.length - 1; ++i) {
            if (prices[i + 1] < tempSell) {
                sumProfit += Math.max(tempSell - tempBuy, 0);
                tempSell = prices[i + 1];
                tempBuy = prices[i + 1];
            } else {
                tempSell = prices[i + 1];
            }
            if (prices[i] < tempBuy) {
                tempBuy = prices[i];
            }
        }
        return sumProfit + Math.max(tempSell - tempBuy, 0);
    }

    /*
    * 题解：累加法
    * 累加每次的股票上涨的差值
    * 时间复杂度：O(n)
    * */
    public int maxProfitIncrease(int[] prices) {
        int sumProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                sumProfit += prices[i + 1] - prices[i];
            }
        }
        return sumProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockII temple = new BestTimeToBuyAndSellStockII();
        System.out.println(temple.maxProfit(new int[]{1,2,3,4,5}));
    }
}
