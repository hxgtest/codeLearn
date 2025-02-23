package hot100and150.回溯法;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hxg
 * @description: 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * @date 2025/2/23 11:53
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
    public void backtrack(List<String> combinations,Map<Character,String> map,String digits,int index,StringBuilder combination){
        if(index==digits.length()){
            combinations.add(combination.toString());
        }else {
            char digit=digits.charAt(index);
            String letters=map.get(digit);
            for(int i=0;i<letters.length();i++){
                combination.append(letters.charAt(i));
                backtrack(combinations,map,digits,index+1,combination);
                combination.deleteCharAt(index);
            }
        }
    }
}
