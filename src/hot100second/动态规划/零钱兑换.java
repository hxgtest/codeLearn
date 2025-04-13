package hot100second.动态规划;

import java.util.Arrays;

/**
 * @author 12293
 * @description: TODO
 * @date 2025/4/13 15:24
 */
public class 零钱兑换 {
    public int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        int n=coins.length;
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            for(int j=0;j<n;j++){
                if(coins[j]<=i){
                    dp[i]=Math.min(dp[i-coins[j]]+1,dp[i]);
                }
            }
        }
        return dp[amount]!=amount+1?dp[amount]:-1;
    }
}
