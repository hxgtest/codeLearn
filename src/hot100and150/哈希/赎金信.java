package hot100and150.哈希;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 12293
 * @description: 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 *
 * 如果可以，返回 true ；否则返回 false 。
 *
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 * @date 2025/2/14 15:28
 */
public class 赎金信 {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> map=new HashMap<>();
        for(char c:ransomNote.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(char c:magazine.toCharArray()){
            if(map.containsKey(c)){
                map.put(c,map.getOrDefault(c,0)-1);
                if(map.get(c)==0){
                    map.remove(c);
                }
            }
        }
        if(map.isEmpty()){
            return true;
        }else {
            return false;
        }
    }
}
