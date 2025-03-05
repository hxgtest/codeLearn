package hot100and150.动态规划;

/**
 * @author 12293
 * @description: 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * @date 2025/3/5 08:45
 */
public class 买卖股票的最佳时机Ⅲ {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length<2){
            return 0;
        }
        int buy1=-prices[0],sell1=0;
        int buy2=-prices[0],sell2=0;
        for(int i=1;i<prices.length;i++){
            buy1=Math.max(buy1,-prices[i]);
            sell1=Math.max(sell1,buy1+prices[i]);
            buy2=Math.max(buy2,sell1-prices[i]);
            sell2=Math.max(sell2,buy2+prices[i]);
        }
        return Math.max(sell1,sell2);
    }
}
