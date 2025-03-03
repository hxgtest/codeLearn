package hot100and150.动态规划;

import java.util.Arrays;

/**
 * @author 12293
 * @description: 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 *
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 *
 * 你可以认为每种硬币的数量是无限的。
 * @date 2025/3/3 09:59
 */
public class 零钱兑换 {
    public int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        int n=coins.length;
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=amount;j++){
                if(j>=coins[i-1]){
                    dp[j]=Math.min(dp[j],dp[j-coins[i-1]]+1);
                }
            }
        }
        return dp[amount]>amount?-1:dp[amount];
    }
}
