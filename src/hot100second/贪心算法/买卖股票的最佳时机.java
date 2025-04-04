package hot100second.贪心算法;

/**
 * @author 12293
 * @description: TODO
 * @date 2025/4/4 20:44
 */
public class 买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int lows;
        int max=0;
        lows=prices[0];
        for(int i=1;i<n;i++){
            lows=Math.min(lows,prices[i]);
            max=Math.max(max,prices[i]-lows);
        }
        return max;
    }
}
