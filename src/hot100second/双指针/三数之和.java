package hot100second.双指针;

import java.util.*;

/**
 * @author 12293
 * @description: TODO
 * @date 2025/3/7 13:14
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
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int third=n-1;
            int target=-nums[i];
            for(int second=i+1;second<n;second++){
                if(second>i+1&&nums[second]==nums[second-1]){
                    continue;
                }
                while (second<third&&nums[second]+nums[third]>target){
                    third--;
                }
                if(second==third){
                    break;
                }
                if (nums[second] + nums[third] == target) {
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
