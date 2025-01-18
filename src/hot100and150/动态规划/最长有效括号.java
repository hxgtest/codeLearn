package hot100and150.动态规划;

import java.util.Stack;

/*给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号
        子串
的长度。*/
public class 最长有效括号 {
    public int longestValidParentheses(String s){
        Stack<Integer> stack=new Stack<>();
        int max=0;
        stack.push(-1);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }else {
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else {
                    max=Math.max(max,i-stack.peek());
                }
            }
        }
        return max;
    }
    public int longestValidParentheses2(String s){
        int max=0;
        int[] dp=new int[s.length()];
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==')'){
                if(s.charAt(i-1)=='('){
                    dp[i]=(i>=2?dp[i-2]:0)+2;
                }else if(s.charAt(i-dp[i-1]-1)=='('&& i-dp[i-1]>0){
                    dp[i]=dp[i-1]+((i-dp[i-1])>=2?dp[i-dp[i-1]-2]:0)+2;
                }
            }
        }
        for(int i:dp){
            max=Math.max(max,i);
        }
        return max;
    }
    public int longestValidParentheses3(String s){
        int left=0,right=0,n=s.length();
        int max=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                left++;
            }else {
                right++;
            }
            if(right==left){
                max=Math.max(right+left,max);
            }
            if(right>left){

                right=0;
                left=0;
            }
        }
        left=0;right=0;
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)=='('){
                left++;
            }else {
                right++;
            }
            if(right==left){
                max=Math.max(right+left,max);
            }
            if(right<left){
                right=0;
                left=0;
            }
        }
        return max;
    }
}
