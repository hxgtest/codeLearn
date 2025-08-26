package hot100_3;

/**
 * @author hxg
 * @description: TODO
 * @date 2025/8/26 20:33
 */
public class 除自身以外数组的乘积 {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] left=new int[n];
        int[] right=new int[n];
        left[0]=1;right[n-1]=1;
        for(int i=1,j=n-2;i<n;i++,j--){
            left[i]=left[i-1]*nums[i-1];
            right[j]=right[j+1]*nums[j+1];
        }
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            ans[i]=left[i]*right[i];
        }
        return ans;
    }
}
