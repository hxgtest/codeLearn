package hot100second.数组;

/**
 * @author hxg
 * @description: TODO
 * @date 2025/3/10 00:55
 */
public class 除自身外数组的乘积 {
    public int[] productExceptSelf(int[] nums) {
        int[] left=new int[nums.length],right=new int[nums.length];
        left[0]=1;
        right[nums.length-1]=1;
        for(int i=1,j=nums.length-2;i<nums.length;i++,j--){
            left[i]=left[i-1]*nums[i];
            right[i]=right[i+1]*nums[i];
        }
        int[] ans=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            ans[i]=left[i]*right[i];
        }
        return ans;
    }
}
