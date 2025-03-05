package hot100and150.动态规划;

/**
 * @author 12293
 * @description: TODO
 * @date 2025/3/5 08:18
 */
public class 编辑距离 {
    public int minDistance(String word1, String word2) {
        int m=word1.length(),n=word2.length();
        if(n*m==0){
            return n+m;
        }
        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            dp[i][0]=i;
        }
        for(int j=0;j<=n;j++){
            dp[0][j]=j;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(word1.charAt(i)==word2.charAt(j)){
                    dp[i][j]=Math.min(Math.min(dp[i-1][j]+1,dp[i][j-1]+1),dp[i-1][j-1]);
                }else {
                    dp[i][j]=Math.min(Math.min(dp[i-1][j]+1,dp[i][j-1]+1),dp[i-1][j-1]+1);
                }
            }
        }
        return dp[m][n];
    }
}
