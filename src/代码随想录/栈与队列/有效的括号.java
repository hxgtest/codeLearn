package 代码随想录.栈与队列;

import java.util.ArrayDeque;
import java.util.Deque;

/*给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
每个右括号都有一个对应的相同类型的左括号。*/
public class 有效的括号 {
    public boolean isValid(String s){
        Deque<Character> stack=new ArrayDeque<>();
        int left=0,right=0;
        for(char i:s.toCharArray()){
            if(i=='('||i=='['||i=='{'){
                left++;
                stack.push(i);
            }else {
                right++;
                if(right>left){
                    return false;
                }
                if(i==')'){
                    if(stack.isEmpty()||stack.peek()!='('){
                        return false;
                    }
                    stack.pop();
                }
                if(i==']'){
                    if(stack.isEmpty()||stack.peek()!='['){
                        return false;
                    }
                    stack.pop();
                }
                if(i=='}'){
                    if(stack.isEmpty()||stack.peek()!='{'){
                        return false;
                    }
                    stack.pop();
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }else {
            return false;
        }
    }
}
