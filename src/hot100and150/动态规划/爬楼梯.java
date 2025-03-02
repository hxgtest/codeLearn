package hot100and150.动态规划;

/**
 * @author hxg
 * @description: 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * @date 2025/3/2 11:20
 */
public class 爬楼梯 {
    public int climbStairs(int n) {
        int[] dp=new int[n];
        dp[0]=0;dp[1]=1;
        for(int i=2;i<n;i++){
            dp[i]=dp[i-2]+dp[i-1];
        }
        return dp[n-1];
    }
}
