package hot100and150.二分查找;
/*给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。

如果数组中不存在目标值 target，返回 [-1, -1]。

你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。*/
public class 在排序数组中查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums,int target){
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
        int l=0,r=nums.length-1;int mid=0;
        int ans=nums.length;
        while(l<=r){
            mid=(l+r)/2;
            if(nums[mid]>=target){
                ans=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
}
