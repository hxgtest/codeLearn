package 代码随想录.栈与队列;

import java.util.ArrayDeque;
import java.util.Deque;

/*给出由小写字母组成的字符串 s，重复项删除操作会选择两个相邻且相同的字母，并删除它们。

在 s 上反复执行重复项删除操作，直到无法继续删除。

在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。*/
public class 删除字符串中的所有相邻重复项 {
    public String removeDuplicates(String s){
        StringBuffer stack=new StringBuffer();
        for(char i:s.toCharArray()){
            if(stack.length()==0){
                stack.append(i);
            }else if(stack.charAt(stack.length()-1)==i){
                stack.deleteCharAt(stack.length()-1);
            }else {
                stack.append(i);
            }
        }
        return stack.toString();
    }
}
