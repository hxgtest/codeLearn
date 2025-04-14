package hot100second.动态规划;

import java.util.Stack;

/**
 * @author 12293
 * @description: TODO
 * @date 2025/4/14 10:58
 */
public class 最长有效括号 {
    public int longestValidParentheses(String s) {
        int n=s.length();
        int maxLen=0;
        Stack<Integer> stack=new Stack<>();
        stack.push(-1);
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }else {
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else {
                    maxLen=Math.max(maxLen,i-stack.peek());
                }
            }
        }
        return maxLen;
    }
    public int longestValidParentheses1(String s){
        int n=s.length();
        int maxans=0;
        int[] dp=new int[n];
        for(int i=1;i<n;i++){
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans=Math.max(maxans,dp[i]);
            }
        }
        return maxans;
    }
    public int longestValidParentheses2(String s){
        int n=s.length();
        int maxans=0;
        int left=0,right=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                left++;
            }else {
                right++;
            }
            if(left==right){
                maxans=Math.max(maxans,2*right);
            }
            if(left<right){
                left=0;
                right=0;
            }
        }
        left=right=0;
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)=='('){
                left++;
            }else {
                right++;
            }
            if(left==right){
                maxans=Math.max(maxans,2*right);
            }
            if(left>right){
                left=0;
                right=0;
            }
        }
        return maxans;
    }
}
