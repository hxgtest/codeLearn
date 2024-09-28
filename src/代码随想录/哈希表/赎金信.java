package 代码随想录.哈希表;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hxg
 * @description: 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * 如果可以，返回 true ；否则返回 false 。
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 * @date 2024/9/28 22:02
 */
public class 赎金信 {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> magazinMap=new HashMap<>();
        for(char c:magazine.toCharArray()){
            magazinMap.put(c,magazinMap.getOrDefault(c,0)+1);
        }
        for(char c:ransomNote.toCharArray()){
            if(magazinMap.getOrDefault(c,0)==0){
                return false;
            }
            magazinMap.put(c,magazinMap.get(c)-1);
        }
        return true;
    }
}
