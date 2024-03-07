package algorithm.gready;
public class Stock{

    public int maxProfitDP(int[] prices) {
	 if (prices.length < 2) {
         return 0;
     }
     int res = 0;
     int[][] dp = new int[prices.length + 1][2];
     dp[0][0] = 0;
     dp[0][1] = Integer.MIN_VALUE;
     dp[1][0] = 0;
     dp[1][1] = -prices[0];
     for (int i = 1; i < prices.length; i ++) {
         dp[i + 1][0] = Math.max(dp[i][0], dp[i][1] + prices[i]);
         dp[i + 1][1] = Math.max(dp[i][1], dp[i-1][0] - prices[i]);
         res = Math.max(res, dp[i + 1][0]);
         res = Math.max(res, dp[i + 1][1]);
     }
     return res;
}
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] buy = new int[n]; // max profit if we buy on ith day
        int[] sell = new int[n]; // max profit if we sell on ith day
        int[] cooldown = new int[n]; // max profit if we cooldown on ith day

        // Initial values for buy and sell
        buy[0] = -prices[0];
        sell[0] = 0;

        for (int i = 1; i < n; i++) {
            // Maximum profit if we buy on ith day is either we don't buy and keep the profit from previous day or we cooldown and buy on ith day
            buy[i] = Math.max(buy[i - 1], cooldown[i - 1] - prices[i]);

            // Maximum profit if we sell on ith day is either we don't sell and keep the profit from previous day or we sell and get the profit for ith day
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);

            // Maximum profit if we cooldown on ith day is either we don't cooldown and keep the profit from previous day or we cooldown after selling on (i-1)th day
            cooldown[i] = Math.max(cooldown[i - 1], sell[i - 1]);
        }

        // Maximum profit is obtained on the last day, either by selling or by cooldown
        return Math.max(sell[n - 1], cooldown[n - 1]);
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2}; // Example input
        Stock  sp = new Stock();
        int maxProfit = sp.maxProfit(prices);
        System.out.println("Maximum Profit: " + maxProfit);
    }
}
 