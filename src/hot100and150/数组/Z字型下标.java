package hot100and150.数组;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hxg
 * @description: 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * @date 2025/2/10 14:13
 */
public class Z字型下标 {
    public String convert(String s, int numRows) {
        if(numRows<2){
            return s;
        }
        List<StringBuilder> rows=new ArrayList<>();
        for(int i=0;i<numRows;i++){
            rows.add(new StringBuilder());
        }
        int i=0,flag=-1;
        for(char c:s.toCharArray()){
            rows.get(i).append(c);
            if(i==0||i==numRows-1){
                flag=-flag;
            }
            i+=flag;
        }
        StringBuilder res=new StringBuilder();
        for(StringBuilder row:rows){
            res.append(row);
        }
        return res.toString();
    }
}
