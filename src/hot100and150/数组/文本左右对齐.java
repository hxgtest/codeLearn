package hot100and150.数组;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hxg
 * @description: TODO
 * @date 2025/2/11 11:23
 */
public class 文本左右对齐 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int right=0,n=words.length;
        //1、只有一个单词，左对齐 2、有多个单词，均匀分配空格，左右对齐 3、最后一行，左对齐
        while(true){
            int left=right;
            int sumLen=0;
            //统计当前行可以放的单词数和总字符数
            while(right<n&&sumLen+words[right].length()+right-left<=maxWidth){
                sumLen+=words[right++].length();
            }
            //当到最后一个单词后
            if(right==n){
                StringBuilder sb=join(words,left,n," ");
                sb.append(blank(maxWidth-sb.length()));
                res.add(sb.toString());
                break;
            }
            int numWord=right-left;
            int numSpace=maxWidth-sumLen;

            //当前行只有一个单词时
            if(numWord==1){
                StringBuilder sb=new StringBuilder(words[left]);
                sb.append(blank(numSpace));
                res.add(sb.toString());
                continue;
            }
            //当前行不止有一个单词时
            int avgSpaces=numSpace/(numWord-1);
            int extraSpaces=numSpace%(numWord-1);
            StringBuilder sb=new StringBuilder();
            sb.append(join(words,left,left+extraSpaces+1,blank(avgSpaces+1)));
            sb.append(blank(avgSpaces));
            sb.append(join(words,left+extraSpaces+1,right,blank(avgSpaces)));
            res.add(sb.toString());
        }
        return res;
    }
    // blank 返回长度为 n 的由空格组成的字符串
    public String blank(int n) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; ++i) {
            sb.append(' ');
        }
        return sb.toString();
    }
    public StringBuilder join(String[] words, int left, int right, String sep) {
        StringBuilder sb = new StringBuilder(words[left]);
        for (int i = left + 1; i < right; ++i) {
            sb.append(sep);
            sb.append(words[i]);
        }
        return sb;
    }
}
