package hot100second.二分查找;

/**
 * @author 12293
 * @description: TODO
 * @date 2025/3/25 10:26
 */
public class 搜索插入位置 {
    public int searchInsert(int[] nums, int target) {
        int n=nums.length;
        int left=0,right=n-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]>target){
                right=mid-1;
            }else {
                left=mid+1;
            }
        }
        return left;
    }
}
