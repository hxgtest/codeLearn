package 代码随想录.动态规划;
//给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
//
//字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
//
//进阶：
//
//如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
//
//致谢：
//
//特别感谢 @pbrother 添加此问题并且创建所有测试用例。
//
//
//
//示例 1：
//
//输入：s = "abc", t = "ahbgdc"
//输出：true
//示例 2：
//
//输入：s = "axc", t = "ahbgdc"
//输出：false
//
//
//提示：
//
//        0 <= s.length <= 100
//        0 <= t.length <= 10^4
//两个字符串都只由小写字符组成。
public class 判断子序列 {
     //没看懂
     public boolean isSubsequence(String s,String t){
          int slen=s.length(),tlen=t.length();
          int[][] f=new int[tlen+1][26];
          for(int i=0;i<26;i++){
               f[tlen][i]=tlen;
          }
          for(int i=tlen-1;i>=0;i--){
               for(int j=0;j<26;j++){
                    if(t.charAt(i)==j+'a'){
                         f[i][j]=i;
                    }else {
                         f[i][j]=f[i+1][j];
                    }
               }
          }
          int add=0;
          for(int i=0;i<slen;i++){
               if(f[add][s.charAt(i)-'a']==tlen){
                    return false;
               }
               add=f[add][s.charAt(i)-'a']+1;
          }
          return true;
     }
     public boolean isSubsequence2(String s,String t){
          int slen=s.length(),tlen=t.length();
          int i=0,j=0;
          while(i<slen&&j<tlen){
               if(s.charAt(i)==t.charAt(j)){
                    i++;
               }
               j++;
          }
          return i==slen;
     }
     public boolean isSubsequence1(String s, String t) {
          int n1=s.length(),n2=t.length();
          int[][] dp=new int[n1+1][n2+1];
          for(int i=1;i<=n1;i++){
               for(int j=1;j<=n2;j++){
                    if(s.charAt(i-1)==t.charAt(j-1)){
                         dp[i][j]=dp[i-1][j-1]+1;
                    }else {
                         dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                    }
               }
          }
          return dp[n1][n2]==s.length();
     }
}
