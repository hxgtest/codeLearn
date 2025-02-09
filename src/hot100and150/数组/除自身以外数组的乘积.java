package hot100and150.数组;

import java.util.Arrays;

/**
 * @author hxg
 * @description: 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 *
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 *
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * @date 2025/2/9 10:07
 */
public class 除自身以外数组的乘积 {
    //用两个数组来记录每个数字左边和右边所有数字的乘积
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] L=new int[n];
        int[] R=new int[n];
        L[0]=1;
        R[n-1]=1;
        for (int i=1;i<n;i++){
            L[i]=L[i-1]*nums[i-1];
        }
        for(int i=n-2;i>=0;i--){
            R[i]=R[i+1]*nums[i+1];
        }
        for(int i=0;i<n;i++){
            nums[i]=L[i]*R[i];
        }
        return nums;
    }
    //双指针
    public int[] productExceptSelf1(int[] nums){
        int n=nums.length;
        int[] ans=new int[n];
        Arrays.fill(ans,1);
        int beforeSum=1;
        int afterSum=1;
        for(int i=0,j=n-1;i<n;i++,j--){
            ans[i]*=beforeSum;
            ans[j]*=afterSum;
            beforeSum*=nums[i];
            afterSum*=nums[j];
        }
        return ans;
    }
    public int[] productExceptSelf2(int[] nums){
        int n=nums.length;
        int[] ans=new int[n];
        ans[0]=1;
        for(int i=1;i<n;i++){
            ans[i]=ans[i-1]*nums[i-1];
        }

        int R=1;
        for(int i=n-1;i>=0;i--){
            ans[i]=ans[i]*R;
            R*=nums[i];
        }
        return ans;
    }
}
