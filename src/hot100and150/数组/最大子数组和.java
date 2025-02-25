package hot100and150.数组;

/**
 * @author 12293
 * @description: 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组是数组中的一个连续部分。
 * @date 2025/2/25 10:29
 */
public class 最大子数组和 {
    public int maxSubArray(int[] nums) {
        int max=nums[0];
        int ans=Integer.MIN_VALUE;
        for(int i=1;i<nums.length;i++){
            max=Math.max(max+nums[i],nums[i]);
            ans=Math.max(ans,max);
        }
        return ans;
    }
    public int maxSubArray1(int[] nums){
        int ans=Integer.MIN_VALUE;
        int minPreSum=0,preSum=0;
        for(int x:nums){
            preSum+=x;
            ans=Math.max(ans,preSum-minPreSum);
            minPreSum=Math.min(minPreSum,preSum);
        }
        return ans;

    }
}
