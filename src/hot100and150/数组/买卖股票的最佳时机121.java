package hot100and150.数组;

/**
 * @author hxg
 * @description: 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * @date 2025/2/4 19:26
 */
public class 买卖股票的最佳时机121 {
    public int maxProfit(int[] prices) {
        int[] lows=new int[prices.length];
        int max=0;
        lows[0]=prices[0];
        for(int i=1;i<prices.length;i++){
            lows[i]=Math.min(lows[i-1],prices[i]);
            if((prices[i]-lows[i])>max){
                max=prices[i]-lows[i];
            }
        }
        return max;
    }
}
