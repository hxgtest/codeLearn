package hot100second.回溯法;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 12293
 * @description: TODO
 * @date 2025/3/21 13:02
 */
public class 括号生成 {
    List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans=new ArrayList<>();
        backtrack(new StringBuilder(),0,0,n);
        return ans;
    }
    public void backtrack(StringBuilder sb,int leftCount,int rightCount,int n){
        if(sb.length()==2*n){
            ans.add(sb.toString());
            return;
        }
        if(leftCount<n){
            sb.append('(');
            leftCount++;
            backtrack(sb,leftCount,rightCount,n);
            sb.deleteCharAt(sb.length()-1);
            leftCount--;
        }
        if(rightCount<leftCount){
            sb.append(')');
            rightCount++;
            backtrack(sb,leftCount,rightCount,n);
            sb.deleteCharAt(sb.length()-1);
            rightCount--;
        }

    }
}
