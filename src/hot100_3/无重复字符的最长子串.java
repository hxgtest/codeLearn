package hot100_3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author hxg
 * @description: TODO
 * @date 2025/8/12 22:15
 */
public class 无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        int max=0;
        int left=0,right=0;
        int n=s.length();
        char[] chars=s.toCharArray();
        Set<Character> map=new HashSet<>();
        while (right<n){
            if(map.contains(chars[right])){
                while (left<=right&&map.contains(chars[right])){
                    map.remove(chars[left]);
                    left++;
                }
            }else {
                map.add(chars[right]);
                right++;
                max=Math.max(max,right-left);
            }
        }
        return max;
    }

}
