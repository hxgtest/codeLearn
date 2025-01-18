package hot100and150.栈;

import java.util.Stack;

/*给定一个经过编码的字符串，返回它解码后的字符串。

编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。

你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。

此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。*/
public class 字符串解码 {
    public static String decodeString(String s){
        StringBuilder ans=new StringBuilder();
        Stack<Character> stack=new Stack<>();
        char[] charArray=s.toCharArray();
        for(int i=charArray.length-1;i>=0;i--){

            int n=0,count=1;
            if(charArray[i]<='9'&&charArray[i]>='0'){
                n=Character.getNumericValue(charArray[i]);
                while(i>0&&charArray[i-1]<='9'&&charArray[i-1]>='0'){

                    n=n+Character.getNumericValue(charArray[i-1])*(int)Math.pow(10,count++);
                    i--;
                }
                StringBuilder sb=new StringBuilder();
                while(true){
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
            }else{
                stack.push(charArray[i]);

            }
        }
        int j=stack.size();
        for(int i=0;i<j;i++){
            ans.append(stack.pop());
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        String s = "100[leetcode]";
        System.out.println(decodeString(s)); // 输出: aaabcbc
    }
}
