package hot100second.滑动窗口;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 12293
 * @description: TODO
 * @date 2025/3/7 14:28
 */
public class 无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        int ans=0;
        int left=0,right=0;
        int n=s.length();
        Set<Character> set=new HashSet<>();
        int length=0;
        while (right<n){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                length++;
                ans=Math.max(ans,length);
                right++;
            }else {
                while (left<right&&set.contains(s.charAt(right))){
                    set.remove(s.charAt(left));
                    length--;
                    left++;
                }
            }

        }
        return ans;
    }
}
