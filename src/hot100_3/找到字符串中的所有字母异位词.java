package hot100_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hxg
 * @description: TODO
 * @date 2025/8/17 23:48
 */
public class 找到字符串中的所有字母异位词 {
    public List<Integer> findAnagrams(String s, String p) {
        int sLen=s.length();
        int pLen=p.length();
        if(sLen<pLen){
            return new ArrayList<>();
        }
        List<Integer> ans=new ArrayList<>();
        int[] sCount=new int[26];
        int[] pCount=new int[26];
        for(int i=0;i<pLen;i++){
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i)-'a']++;
        }
        if(Arrays.equals(sCount,pCount)){
            ans.add(0);
        }
        for(int i=0;i<sLen-pLen;i++){
            sCount[s.charAt(i) - 'a']--;
            sCount[s.charAt(i+pLen)-'a']++;
            if(Arrays.equals(sCount,pCount)){
                ans.add(i+1);
            }
        }
        return ans;
    }
}
