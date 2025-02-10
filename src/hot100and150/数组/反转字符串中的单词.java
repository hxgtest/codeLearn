package hot100and150.数组;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author hxg
 * @description: 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 *
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 *
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 *
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 * @date 2025/2/10 13:23
 */
public class 反转字符串中的单词 {
    public String reverseWords(String s) {
        //先全部反转，再逐个反转

        StringBuilder sb=removeSpace(s);
        reverseEachWord(sb);
        return sb.toString();
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
    public StringBuilder removeSpace(String s){
        int start=0,end=s.length()-1;
        while(s.charAt(start)==' '){
            start++;
        }
        while (s.charAt(end)==' '){
            end--;
        }
        StringBuilder sb=new StringBuilder();
        while(start<=end){
            char c=s.charAt(start);
            if(c!=' '||sb.charAt(sb.length()-1)!=' '){
                sb.append(c);
            }
            start++;
        }
        return sb;
    }
    public void reverseEachWord(StringBuilder sb){
        int start=0,end=1;
        int n=sb.length();
        while (start<n){
            while(sb.charAt(end)!=' '){
                end++;
            }
            reverseString(sb,start,end-1);
            start=end++;
        }
    }

    public String reverseWords1(String s){
        int left = 0, right = s.length() - 1;
        // 去掉字符串开头的空白字符
        while (left <= right && s.charAt(left) == ' ') {
            ++left;
        }

        // 去掉字符串末尾的空白字符
        while (left <= right && s.charAt(right) == ' ') {
            --right;
        }

        Deque<String> deque=new ArrayDeque<>();
        StringBuilder word=new StringBuilder();
        while(left<=right){
            char c=s.charAt(left);
            if((word.length()!=0)&&(c==' ')){
                deque.offerFirst(word.toString());
                word.setLength(0);
            }else if(c!=' '){
                word.append(c);
            }
            left++;
        }
        deque.offerFirst(word.toString());
        return String.join(" ",deque);
    }

}
