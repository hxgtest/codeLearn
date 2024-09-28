package 代码随想录.哈希表;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hxg
 * @description: 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
 *
 * 你可以按任意顺序返回答案。
 * @date 2024/9/28 21:35
 */
public class 两数之和 {
    public int[] twoSum(int[] nums, int target) {
        int remain=0;
        Map<Integer,Integer> rec=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            remain=target-nums[i];
            if(rec.containsKey(nums[i])){
                int[] ans=new int[]{i,rec.getOrDefault(nums[i],0)};
                return ans;
            }else {
                rec.put(remain,i);
            }
        }
        return null;
    }
}
