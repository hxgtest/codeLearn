package 代码随想录.动态规划;

import java.util.Arrays;

/*给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。

完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。



示例 1：

输入：n = 12
输出：3
解释：12 = 4 + 4 + 4
示例 2：

输入：n = 13
输出：2
解释：13 = 4 + 9

提示：

        1 <= n <= 104*/
public class 完全平方数 {
    public int numSquares(int n) {
        int[] squares=new int[100];
        for(int i=0;i<100;i++){
            squares[i]=(i+1)*(i+1);
        }
        int[] dp=new int[n+1];
        Arrays.fill(dp,n+1);
        dp[0]=0;
        for(int i=0;i<100;i++){
            if(squares[i]>n){
                break;
            }else if(squares[i]==n){
                return 1;
            }
            for(int j=1;j<=n;j++){
                if(j>=squares[i]){
                    dp[j]=Math.min(dp[j],dp[j-squares[i]]+1);
                }
            }
        }
        return dp[n];
    }
}
