package hot100second.动态规划;

/**
 * @author 12293
 * @description: TODO
 * @date 2025/4/16 09:27
 */
public class 最长回文子串 {
    public String longestPalindrome(String s) {
        int n=s.length();
        if(n<2){
            return s;
        }
        int maxLen=1;
        int begin=0;
        boolean[][] dp=new boolean[n][n];
        for(int i=0;i<n;i++){
            dp[i][i]=true;
        }
        for(int i=0;i<n-1;i++){
            if((s.charAt(i)==s.charAt(i+1))){
                dp[i][i+1]=true;
                maxLen=2;
                begin=i;
            }
        }
        for(int L=1;L<=s.length();L++){
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
                    begin=i;
                    maxLen=j-i+1;
                }
            }
        }
        return s.substring(begin,begin+maxLen);

    }
    public String longestPalindrome1(String s){
        if(s==null||s.isEmpty()){
            return "";
        }
        int start=0,end=0;
        for(int i=0;i<s.length();i++){
            int len1=expandAroundCenter(s,i,i);
            int len2=expandAroundCenter(s,i,i+1);
            int len=Math.max(len1,len2);
            if(len>end-start){
                start=i-(len-1)/2;
                end=i+len/2;
            }
        }
        return s.substring(start,end+1);
    }
    public int expandAroundCenter(String s,int left,int right){
        while (left>0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
}
