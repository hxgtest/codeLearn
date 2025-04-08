package hot100second.动态规划;

/**
 * @author 12293
 * @description: TODO
 * @date 2025/4/8 11:05
 */
public class 爬楼梯 {
    public int climbStairs(int n){

        int[] dp=new int[n+1];
        dp[0]=1;dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-2]+dp[i-1];
        }
        return dp[n];

    }
}
