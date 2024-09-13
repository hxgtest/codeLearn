package hot100.动态规划;
/*
给你一个字符串 s，找到 s 中最长的 回文子串。
*/
public class 最长回文子串 {
    public String longestPalindrome(String s){
        if(s==null||s.length()==0){
            return "";
        }
        int start=0,end=0;
        for(int i=0;i<s.length();i++){
            int len1=expand(s,i,i);
            int len2=expand(s,i,i+1);
            int len=Math.max(len1,len2);
            if(len>end-start){
                end=i+len/2;
                start=i-(len-1)/2;
            }
        }
        return s.substring(start,end+1);
    }
    public int expand(String s,int left,int right){
        while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
    public String longestPalindrome1(String s){
        int maxLen=1;
        int begin=0;
        boolean[][] dp=new boolean[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            dp[i][i]=true;
            if(i+1<s.length()){
                dp[i][i+1]=s.charAt(i)==s.charAt(i+1);
            }
        }
        for(int L=2;L<=s.length();L++){
            for(int i=0;i<s.length();i++){
                int j=L+i-1;
                if(j>=s.length()){
                    break;
                }
                if(s.charAt(i)!=s.charAt(j)){
                    dp[i][j]=false;
                }else {
                    if(j-i<3){
                        dp[i][j]=true;
                    }else {
                        dp[i][j]=dp[i+1][j-1];
                    }
                }
                if(dp[i][j]&&j-i+1>maxLen){
                    maxLen=j-i+1;
                    begin=i;
                }
            }
        }
        return s.substring(begin,begin+maxLen);
    }
}
