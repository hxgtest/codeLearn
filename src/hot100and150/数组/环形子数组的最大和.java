package hot100and150.数组;

/**
 * @author 12293
 * @description: 给定一个长度为 n 的环形整数数组 nums ，返回 nums 的非空 子数组 的最大可能和 。
 *
 * 环形数组 意味着数组的末端将会与开头相连呈环状。形式上， nums[i] 的下一个元素是 nums[(i + 1) % n] ， nums[i] 的前一个元素是 nums[(i - 1 + n) % n] 。
 *
 * 子数组 最多只能包含固定缓冲区 nums 中的每个元素一次。形式上，对于子数组 nums[i], nums[i + 1], ..., nums[j] ，不存在 i <= k1, k2 <= j 其中 k1 % n == k2 % n 。
 * @date 2025/2/26 09:05
 */
public class 环形子数组的最大和 {
    public int maxSubarraySumCircular(int[] nums) {
        int n=nums.length;
        int[] leftMax=new int[n];

        leftMax[0]=nums[0];
        int leftSum=nums[0];
        int pre=nums[0];
        int res=nums[0];
        for(int i=1;i<n;i++){
            pre=Math.max(pre+nums[i],nums[i]);
            res=Math.max(res,pre);
            leftSum+=nums[i];
            leftMax[i]=Math.max(leftMax[i-1],leftSum);
        }
        int rightSum=0;
        for(int i=n-1;i>0;i--){
            rightSum+=nums[i];
            res=Math.max(res,rightSum+leftMax[i-1]);
        }
        return res;
    }
    public int maxSubarraySumCircular1(int[] nums){
        int n=nums.length;
        int preMax=nums[0],maxRes=nums[0];
        int preMin=nums[0],minRes=nums[0];
        int sum=nums[0];
        for(int i=1;i<n;i++){
            preMax=Math.max(preMax+nums[i],nums[i]);
            maxRes=Math.max(maxRes,preMax);
            preMin=Math.min(preMin+nums[i],nums[i]);
            minRes=Math.min(minRes,preMin);
            sum+=nums[i];
        }
        if(maxRes<0){
            return maxRes;
        }else {
            return Math.max(maxRes,sum-minRes);
        }
    }
}
