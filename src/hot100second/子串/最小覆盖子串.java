package hot100second.子串;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author hxg
 * @description: 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * @date 2025/3/9 23:46
 */
public class 最小覆盖子串 {
    Map<Character,Integer> sMap=new HashMap<>();
    Map<Character,Integer> tMap=new HashMap<>();
    public String minWindow(String s, String t) {
        for(char word:t.toCharArray()){
            tMap.put(word,tMap.getOrDefault(word,0)+1);
        }
        int l=0,r=-1;
        int ansL=-1,ansR=-1;
        int length=Integer.MAX_VALUE;
        while (r<s.length()){
            r++;
            if(r<s.length()&&tMap.containsKey(s.charAt(r))){
                sMap.put(s.charAt(r),sMap.getOrDefault(s.charAt(r),0)+1);
            }
            while (check()&&l<=r){
                if(r-l+1<length){
                    length=r-l+1;
                    ansL=l;
                    ansR=l+length;
                }
                if(tMap.containsKey(s.charAt(l))){
                    sMap.put(s.charAt(l),sMap.getOrDefault(s.charAt(l),0)-1);
                }
                l++;
            }
        }
        return ansL==-1?"":s.substring(ansL,ansR);
    }
    public boolean check(){
        for (Map.Entry<Character, Integer> characterIntegerEntry : tMap.entrySet()) {
            Map.Entry entry = (Map.Entry) characterIntegerEntry;
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (sMap.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }
}
