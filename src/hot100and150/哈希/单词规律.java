package hot100and150.哈希;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hxg
 * @description: 给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
 * <p>
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。
 * @date 2025/2/15 09:49
 */
public class 单词规律 {
    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        if (pattern.length() != words.length) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            if (!map1.containsKey(pattern.charAt(i))) {
                map1.put(pattern.charAt(i), words[i]);
                if (map2.containsKey(words[i]) && !map2.get(words[i]).equals(pattern.charAt(i))) {
                    return false;
                }
                map2.put(words[i], pattern.charAt(i));
            } else if (!map1.get(pattern.charAt(i)).equals(words[i])) {
                return false;
            }
        }
        return true;
    }

}
