package hot100second.回溯法;

import hot100and150.链表.随机链表的复制;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 12293
 * @description: TODO
 * @date 2025/3/21 14:41
 */
public class 分割回文串 {
    boolean[][] dp;
    List<List<String>> ret=new ArrayList<>();
    List<String> ans=new ArrayList<>();
    int n;
    public List<List<String>> partition(String s) {
        n=s.length();
        dp=new boolean[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],true);
        }
        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<n;j++){
                dp[i][j]=(s.charAt(i)==s.charAt(j))&&dp[i+1][j-1];
            }
        }
        backtrack(s,0);
        return ret;

    }
    public void backtrack(String s,int i){
        if(i==n){
            ret.add(new ArrayList<>(ans));
            return;
        }
        for(int j=i;j<n;j++){
            if(dp[i][j]){
                ans.add(s.substring(i,j+1);
                backtrack(s,j+1);
                ans.remove(ans.size()-1);
            }
        }
    }
}
