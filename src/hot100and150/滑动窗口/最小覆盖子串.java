package hot100and150.滑动窗口;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author hxg
 * @description: 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * @date 2025/2/13 12:34
 */
public class 最小覆盖子串 {
    Map<Character,Integer> ori=new HashMap<>();
    Map<Character,Integer> cnt=new HashMap<>();
    public String minWindow(String s, String t) {
        int sLen=s.length();
        int ansL=-1,ansR=-1;
        int len=Integer.MAX_VALUE;
        for(char charT:t.toCharArray()){
            ori.put(charT,ori.getOrDefault(charT,0)+1);
        }
        int l=0,r=-1;
        while(r<sLen){
            r++;
            if(r<sLen&&ori.containsKey(s.charAt(r))){
                cnt.put(s.charAt(r),cnt.getOrDefault(s.charAt(r),0)+1);
            }
            while(check()&&l<=r){
                if(r-l+1<len){
                    len=r-l+1;
                    ansL=l;
                    ansR=l+len;
                }
                if(ori.containsKey(s.charAt(l))){
                    cnt.put(s.charAt(l),cnt.getOrDefault(s.charAt(l),0)-1);
                }
                l++;
            }
        }
        return len==Integer.MAX_VALUE?"":s.substring(ansL,ansR);
    }
    public boolean check(){
        Iterator iter=ori.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry entry=(Map.Entry)iter.next();
            Character key= (Character) entry.getKey();
            Integer value= (Integer) entry.getValue();
            if(cnt.getOrDefault(key,0)<value){
                return false;
            }
        }
        return true;
    }
}
