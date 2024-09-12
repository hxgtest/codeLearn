package hot100.动态规划;

import java.util.*;
/*给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续
        子数组
（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。

测试用例的答案是一个 32-位 整数。*/
public class 乘积最大子数组 {
    public int maxProduct(int[] nums){
        int max=Integer.MIN_VALUE,imax=1,imin=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                int temp=imax;
                imax=imin;
                imin=temp;
            }
            imax=Math.max(imax*nums[i],nums[i]);
            imin=Math.min(imin*nums[i],nums[i]);
            max=Math.max(max,imax);
        }
        return max;
    }
}
