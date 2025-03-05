package hot100and150.动态规划;

import java.util.Arrays;

/**
 * @author 12293
 * @description: 给你一个整数数组 prices 和一个整数 k ，其中 prices[i] 是某支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。也就是说，你最多可以买 k 次，卖 k 次。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * @date 2025/3/5 09:34
 */
public class 买卖股票的最佳时机Ⅳ {
    public int maxProfit(int k, int[] prices) {
        if(prices==null||prices.length<2){
            return 0;
        }
        int[] buy=new int[k];
        int[] sell=new int[k];
        Arrays.fill(buy, Integer.MIN_VALUE);
        buy[0]=-prices[0];
        for(int i=1;i<prices.length;i++){
            // 先更新第一次交易的状态
            buy[0] = Math.max(buy[0], -prices[i]);
            sell[0] = Math.max(sell[0], buy[0] + prices[i]);
            for(int j=1;j<k;j++){
                buy[j]=Math.max(buy[j],sell[j-1]-prices[i]);
                sell[j]=Math.max(sell[j],buy[j]+prices[i]);
            }
        }

        return Arrays.stream(sell).max().getAsInt();
    }
}
