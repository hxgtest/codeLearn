package hot100and150.数组;

/**
 * @author hxg
 * @description: 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 *
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 *
 * 返回 你能获得的 最大 利润 。
 * @date 2025/2/8 16:01
 */
public class 买卖股票的最佳时机Ⅱ122 {
    public int maxProfit1(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n][2];
        //dp[i][0]表示在第i天未持有股票时的最大利润，dp[i][1]表示在第i天持有股票时的最大利润
        //未持有可能是这一天卖了也可能是早几天卖了，持有可能是这一天买了也可能是早几天买了
        //dp[i][0]=dp[i-1][0]与prices[i]+dp[i-1][1]之间的最大值
        //dp[i][1]=dp[i-1][1]与-prices[i]+dp[i-1][0]之间的较大值
        dp[0][0]=0;dp[0][1]=-prices[0];
        for(int i=1;i<n;i++){
            dp[i][0]=Math.max(dp[i-1][0],prices[i]+dp[i-1][1]);
            dp[i][1]=Math.max(dp[i-1][1],-prices[i]+dp[i-1][0]);
        }
        return dp[n-1][0];
    }
    //优化dp数组
    public int maxProfit2(int[] prices) {
        int n=prices.length;
        //dp[i][0]表示在第i天未持有股票时的最大利润，dp[i][1]表示在第i天持有股票时的最大利润
        //未持有可能是这一天卖了也可能是早几天卖了，持有可能是这一天买了也可能是早几天买了
        //dp[i][0]=dp[i-1][0]与prices[i]+dp[i-1][1]之间的最大值
        //dp[i][1]=dp[i-1][1]与-prices[i]+dp[i-1][0]之间的较大值
        int dp0=0,dp1=-prices[0];
        for(int i=1;i<n;i++){
            int newdp0=Math.max(dp0,prices[i]+dp1);
            int newdp1=Math.max(dp1,-prices[i]+dp0);
            dp0=newdp0;
            dp1=newdp1;
        }
        return dp0;
    }

    //贪心
    public int maxProfit3(int[] prices) {
        int maxProfit=0;
        for(int i=0;i<prices.length-1;i++){
            if(prices[i+1]-prices[i]>0){
                maxProfit+=prices[i+1]-prices[i];
            }
        }
        return maxProfit;
    }
}
