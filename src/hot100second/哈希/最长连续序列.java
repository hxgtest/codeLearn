package hot100second.哈希;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 12293
 * @description: TODO
 * @date 2025/3/6 09:16
 */
public class 最长连续序列 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        int max=0;
        for(int i:set){
            if(!set.contains(i-1)){
                int len=1;
                int cur=i;
                while (set.contains(cur+1)){
                    len++;
                    cur++;
                }
                max=Math.max(max,len);
            }
        }
        return max;
    }
}
