package hot100second.动态规划;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 12293
 * @description: TODO
 * @date 2025/4/13 16:07
 */
public class 单词拆分 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n=s.length();
        Set<String> set=new HashSet<>(wordDict);
        boolean[] dp=new boolean[n+1];
        dp[0]=true;
        for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++){
                if(dp[j]&&set.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
