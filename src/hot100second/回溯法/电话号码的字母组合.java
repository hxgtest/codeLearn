package hot100second.回溯法;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 12293
 * @description: TODO
 * @date 2025/3/20 09:51
 */
public class 电话号码的字母组合 {
    public List<String> letterCombinations(String digits) {
        List<String> ans=new ArrayList<>();
        if(digits.length()==0){
            return ans;
        }
        Map<Character,String> map=new HashMap<Character,String>(){{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }
        };
        backtrack(ans,map,digits,0,new StringBuilder());
        return ans;
    }
    public void backtrack(List<String> ans,Map<Character,String> map,String digits,int index,StringBuilder sb){
        if(index==digits.length()){
            ans.add(sb.toString());
        }else {
            char digit=digits.charAt(index);
            String letters=map.get(digit);
            for(int i=0;i<letters.length();i++){
                sb.append(letters.charAt(i));
                backtrack(ans,map,digits,index+1,sb);
                sb.deleteCharAt(index);
            }
        }
    }
}
