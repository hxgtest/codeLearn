package hot100second.二分查找;

/**
 * @author 12293
 * @description: TODO
 * @date 2025/3/25 11:00
 */
public class 在排序数组中查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target) {
        if(nums==null){
            return new int[]{-1,-1};
        }
        int start=searchInsert(nums,target-0.5);
        int end=searchInsert(nums,target+0.5);
        if(start>=end){
            return new int[]{-1,-1};
        }
        return new int[]{start,end-1};
    }
    public int searchInsert(int[] nums,double target){
        int l=0,r=nums.length-1,mid=0;
        int ans=nums.length;
        while (l<=r){
            mid=(l+r)/2;
            if(nums[mid]>=target){
                ans=mid;
                r=mid-1;
            }else {
                l=mid+1;
            }
        }
        return ans;
    }
}
