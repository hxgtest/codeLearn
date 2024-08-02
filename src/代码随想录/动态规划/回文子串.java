package 代码随想录.动态规划;
//给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
//
//回文字符串 是正着读和倒过来读一样的字符串。
//
//子字符串 是字符串中的由连续字符组成的一个序列。
//
//
//
//示例 1：
//
//输入：s = "abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
//示例 2：
//
//输入：s = "aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
//
//
//提示：
//
//        1 <= s.length <= 1000
//s 由小写英文字母组成
public class 回文子串 {
    public int countSubstrings(String s){
        int n=s.length(),ans=0;
        boolean[][] dp=new boolean[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                if(s.charAt(i)==s.charAt(j)&&(i-j<2||dp[j+1][i-1])){
                    dp[j][i]=true;
                    ans++;
                }
            }
        }
        return ans;
    }
    public int countSubstrings1(String s){
        int n=s.length(),ans=0;
        for(int i=0;i<2*n-1;i++){
            int l=i/2,r=i/2+i%2;
            while(l>=0&&r<n&&s.charAt(l)==s.charAt(r)){
                l--;
                r++;
                ans++;
            }
        }
        return ans;
    }
}
