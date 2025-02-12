package hot100and150.双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hxg
 * @description: 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 * @date 2025/2/12 10:53
 */
public class 三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
        if(nums[0]>0){
            return ans;
        }
        for(int i=0;i<n;i++){
            if (i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int third=n-1;
            int target=-nums[i];
            for(int second=i+1;second<n;second++){
                if(second>i+1&&nums[second]==nums[second-1]){
                    continue;
                }
                while(second<third&&nums[second]+nums[third]>target){
                    third--;
                }
                if(second==third){
                    break;
                }
                if(nums[second]+nums[third]==target){
                    List<Integer> list=new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}
