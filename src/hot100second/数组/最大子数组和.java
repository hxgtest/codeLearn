package hot100second.数组;

/**
 * @author hxg
 * @description: TODO
 * @date 2025/3/10 00:21
 */
public class 最大子数组和 {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        int max=nums[0];
        int ans=max;
        for(int i=1;i<n;i++){
            max=Math.max(max+nums[i],nums[i]);
            ans=Math.max(ans,max);
        }
        return ans;

    }
}
