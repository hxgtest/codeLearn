package hot100and150.滑动窗口;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author hxg
 * @description: 给定一个字符串 s ，请你找出其中不含有重复字符的 最长
 * 子串
 * 的长度。
 * @date 2025/2/12 11:31
 */
public class 无重复字符的最常子串 {

    public int lengthOfLongestSubstring(String s) {
        int start = 0, end = 0;
        int length = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();
        while (end < s.length()) {
            if (!set.contains(s.charAt(end))) {
                set.add(s.charAt(end));
                end++;
                length++;
                max = Math.max(max, length);
            } else {

                while (start <= end && set.contains(s.charAt(end))) {
                    set.remove(s.charAt(start++));
                    length--;
                }
            }
        }
        return max;
    }
}
