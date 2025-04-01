package hot100second.栈;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author 12293
 * @description: TODO
 * @date 2025/3/30 16:08
 */
public class 字符串解码 {
    public String decodeString(String s) {
        Stack<Character> stack=new Stack<>();
        StringBuilder ans=new StringBuilder();
        char[] charArray=s.toCharArray();
        for(int i=charArray.length-1;i>=0;i--){
            int n=0,count=1;
            if(charArray[i]<='9'&&charArray[i]>='0'){
                n=Character.getNumericValue(charArray[i]);
                while (i>0&&charArray[i-1]<='9'&&charArray[i-1]>='0'){
                    n=n+Character.getNumericValue(charArray[i-1])*(int) Math.pow(10,count++);
                    i--;
                }
                StringBuilder sb=new StringBuilder();
                while (true){
                    if(stack.peek()>='a'&&stack.peek()<='z'){
                        sb.append(stack.pop());
                    }else {
                        if(stack.pop().equals(']')){
                            break;
                        }
                    }
                }
                for(int j=1;j<=n;j++){
                    for(int m=sb.length()-1;m>=0;m--){
                        stack.push(sb.charAt(m));
                    }
                }
            }else {
                stack.push(charArray[i]);
            }
        }
        int j=stack.size();
        for (int i=0;i<j;i++){
            ans.append(stack.pop());
        }
        return ans.toString();

    }
    public String decodeString1(String s){
        StringBuilder res=new StringBuilder();
        int multi=0;
        LinkedList<Integer> multi_stack = new LinkedList<>();
        LinkedList<String> res_stack=new LinkedList<>();
        for(Character c:s.toCharArray()){
            if(c=='['){
                multi_stack.addLast(multi);
                res_stack.addLast(res.toString());
                multi=0;
                res=new StringBuilder();
            }else if(c==']'){
                StringBuilder tmp=new StringBuilder();
                int cur_multi=multi_stack.removeLast();
                for(int i=0;i<cur_multi;i++){
                    tmp.append(res);
                }
                res=new StringBuilder(res_stack.removeLast()+tmp);
            }else if(c>='0'&&c<='9'){
                multi=multi*10+Integer.parseInt(c+"");
            }else {
                res.append(c);
            }
        }
        return res.toString();
    }
}
