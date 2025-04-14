package hot100second.动态规划;

/**
 * @author 12293
 * @description: TODO
 * @date 2025/4/14 09:54
 */
public class 乘积最大子数组 {
    public int maxProduct(int[] nums) {
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
