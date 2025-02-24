package hot100and150.回溯法;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 12293
 * @description: 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * @date 2025/2/24 09:33
 */
public class 括号生成Ⅱ {
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        int left=0,right=0;
        backtrack(n,left,right,new StringBuilder(),ans);
        return ans;
    }
    public void backtrack(int n,int left,int right,StringBuilder sb,List<String> ans){
        if(sb.length()==n){
            ans.add(sb.toString());
            return;
        }
        if(left<n/2){
            sb.append('(');
            left++;
            backtrack(n,left,right,sb,ans);
            sb.deleteCharAt(sb.length()-1);
            left--;
        }

        if(left>right){
            sb.append(')');
            right++;
            backtrack(n,left,right,sb,ans);
            sb.deleteCharAt(sb.length()-1);
            right--;
        }
    }
}
