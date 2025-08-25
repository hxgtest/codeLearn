package hot100_3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hxg
 * @description: TODO
 * @date 2025/8/18 00:15
 */
public class 和为K的子数组 {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> prefixCount=new HashMap<>();
        int prefix=0;
        int count=0;
        for(int num:nums){
            prefix+=num;
            prefixCount.put(prefix,prefixCount.getOrDefault(prefix,0)+1);
            count+=prefixCount.getOrDefault(prefix-k,0);
        }
        return count;
    }
}
