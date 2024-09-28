package 代码随想录.哈希表;

import java.util.Arrays;

/**
 * @author hxg
 * @description: 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的
 * 字母异位词
 * @date 2024/9/28 20:20
 */

public class 有效的字母异位词 {
    public boolean isAnagram(String s,String t){
        if(s.length()!=t.length()){
            return false;
        }
        char[] chars1=s.toCharArray();
        char[] chars2=t.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        for(int i=0;i<s.length();i++){
            if(chars1[i]!=chars2[i]){
                return false;
            }
        }
        return true;
    }
}
