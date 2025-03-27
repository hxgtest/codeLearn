package hot100second.二分查找;

/**
 * @author hxg
 * @description: TODO
 * @date 2025/3/28 01:06
 */
public class 寻找排序数组中的最小值 {
    public int findMin(int[] nums) {
        int ans=nums[0];
        int n=nums.length;
        int l=0,r=n-1;
        while (l<=r){
            int mid=l+(r-l)/2;
            ans=Math.min(ans,nums[mid]);
            if(nums[0]<=nums[mid]){
                l=mid+1;
            }else {
                r=mid-1;
            }
        }
        return ans;
    }
}
