package 代码随想录.字符串;

/**
 * @author hxg
 * @description: 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 * @date 2024/10/1 09:04
 */
public class 反转字符串中的单词 {
    public String reverseWords(String s) {
        StringBuilder sb=removeSpace(s);
        reverseString(sb,0,sb.length());
        reverseEachWord(sb);
        return sb.toString();
    }
    public StringBuilder removeSpace(String s){
        int start=0;
        int end=s.length()-1;
        while(s.charAt(start)==' '){
            start++;
        }
        while (s.charAt(end)==' '){
            end--;
        }
        StringBuilder sb=new StringBuilder();
        while(start<end){
            char c=s.charAt(start);
            if(c!=' '||sb.charAt(sb.length()-1)!=' '){
                sb.append(c);
            }
            start++;
        }
        return sb;
    }
    public void reverseString(StringBuilder sb,int start,int end){
        while(start<end){
            char temp=sb.charAt(start);
            sb.setCharAt(start,sb.charAt(end));
            sb.setCharAt(end,temp);
            start++;
            end--;
        }
    }
    public void reverseEachWord(StringBuilder sb){
        int start=0;
        int end=1;
        int n=sb.length();
        while(start<n){
            while(end<n&& sb.charAt(end)!=' '){
                end++;
            }
            reverseString(sb,start,end);
            start=end+1;
            end=start+1;
        }
    }
}
