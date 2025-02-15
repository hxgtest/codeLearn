package hot100and150.哈希;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hxg
 * @description: 给定两个字符串 s 和 t ，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 *
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 * @date 2025/2/15 09:40
 */
public class 同构字符串 {
    public boolean isIsomorphic(String s, String t) {

        int n=s.length();
        Map<Character,Character> map1 =new HashMap<>();
        Map<Character,Character> map2 =new HashMap<>();
        for(int i=0;i<n;i++){
            if(!map1.containsKey(s.charAt(i))){
                map1.put(s.charAt(i),t.charAt(i));
                if(!map2.containsKey(t.charAt(i))){
                    map2.put(t.charAt(i),s.charAt(i));
                }else {
                    return false;
                }
            }else {
                if(t.charAt(i)!=map1.get(s.charAt(i))){
                    return false;
                }
            }
        }
        return true;
    }

}
