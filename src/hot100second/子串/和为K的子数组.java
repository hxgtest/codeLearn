package hot100second.子串;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hxg
 * @description: 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 *
 * 子数组是数组中元素的连续非空序列。
 * @date 2025/3/8 13:00
 */
public class 和为K的子数组 {
    public int subarraySum(int[] nums, int k) {
        int count=0,pre=0;
        Map<Integer,Integer> mp=new HashMap<>();
        mp.put(0,1);
        for(int i=0;i<nums.length;i++){
            pre+=nums[i];
            if(mp.containsKey(pre-k)){
                count+=mp.get(pre-k);
            }
            mp.put(pre,mp.getOrDefault(pre,0)+1);
        }
        return count;
    }
}
