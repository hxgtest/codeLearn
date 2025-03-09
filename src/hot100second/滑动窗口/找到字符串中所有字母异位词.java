package hot100second.滑动窗口;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hxg
 * @description: 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * @date 2025/3/8 10:33
 */
public class 找到字符串中所有字母异位词 {
    public List<Integer> findAnagrams(String s, String p) {
        int sLen=s.length(),pLen=p.length();
        if(sLen<pLen){
            return new ArrayList<Integer>();
        }
        List<Integer> ans=new ArrayList<>();
        int[] sCount=new int[26];
        int[] pCount=new int[26];
        for(int i=0;i<pLen;i++){
            ++sCount[s.charAt(i)-'a'];
            ++pCount[s.charAt(i)-'a'];
        }
        if(Arrays.equals(sCount,pCount)){
            ans.add(0);
        }
        for(int i=0;i<sLen-pLen;i++){
            --sCount[s.charAt(i)-'a'];
            ++sCount[s.charAt(i+pLen)-'a'];
            if(Arrays.equals(sCount,pCount)){
                ans.add(i+1);
            }
        }
        return ans;
    }
}
