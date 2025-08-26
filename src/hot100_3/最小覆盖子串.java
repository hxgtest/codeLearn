package hot100_3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hxg
 * @description: TODO
 * @date 2025/8/25 21:26
 */
public class 最小覆盖子串 {
    Map<Character,Integer> tMap;
    Map<Character,Integer> sMap;
    public String minWindow(String s, String t) {
        tMap=new HashMap<>();
        sMap=new HashMap<>();
        for(Character charT:t.toCharArray()){
            tMap.put(charT,tMap.getOrDefault(charT,0)+1);
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
        return ansL!=-1?s.substring(ansL,ansR):"";
    }
    public boolean check(){
        for(Map.Entry<Character,Integer> characterIntegerEntry:tMap.entrySet()){
            Map.Entry entry=(Map.Entry)characterIntegerEntry;
            Character key=(Character) entry.getKey();
            Integer value=(Integer) entry.getValue();
            if(sMap.getOrDefault(key,0)<value){
                return false;
            }
        }
        return true;
    }
}
