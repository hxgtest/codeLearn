package hot100and150.哈希;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author hxg
 * @description: 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
 * @date 2025/2/15 11:10
 */
public class 存在重复元素2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(i>k){
                set.remove(nums[i]);
            }
            if(!set.add(nums[i])){
                return true;
            }
        }
        return false;
    }
}
