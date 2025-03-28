package hot100second.栈;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author 12293
 * @description: TODO
 * @date 2025/3/28 15:04
 */
public class 有效的括号 {
    public boolean isValid(String s) {
        Deque<Character> deque=new LinkedList<>();
        for(char c:s.toCharArray()){
            if(c=='('||c=='['||c=='{'){
                deque.push(c);
            }else if(!deque.isEmpty()){
                if((c==')'&&deque.peek()=='(')||(c==']'&&deque.peek()=='[')||(c=='}'&&deque.peek()=='{')){
                    deque.pop();
                }else {
                    return false;
                }
            }
            else{
                return false;
            }
        }
        return deque.isEmpty();
    }
}
