package 代码随想录.数组;

import java.util.Arrays;

/**
 * @author hxg
 * @description: TODO
 * @date 2024/9/17 15:29
 */
/*给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。*/
public class 有序数组的平方 {
    public int[] sortedSquares(int[] nums){
        //方法一直接排序
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                nums[i]*=-1;
            }
        }
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            nums[i]*=nums[i];
        }
        return nums;
    }
    public int[] sortedSquares1(int[] nums){
        //双指针
        int[] ans=new int[nums.length];
        int l=0,r=nums.length-1;
        for(int i=nums.length-1;i>=0;i--){
            if(nums[l]+nums[r]>=0){
                ans[i]=nums[r]*nums[r];
                r--;
            }else {
                ans[i]=nums[l]*nums[l];
                l++;
            }
        }
        return ans;
    }
}
