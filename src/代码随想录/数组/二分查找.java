package 代码随想录.数组;

/**
 * @author hxg
 * @description: TODO
 * @date 2024/9/17 15:16
 */
public class 二分查找 {
    public int search(int[] nums, int target) {
        int n=nums.length;
        int l=0,r=n-1;
        while (l<=r){
            int mid=(l+r)>>1;
            if (nums[mid] == target) {
                return mid;
            }else if(nums[mid]<target){
                l=mid+1;
            }else {
                r=mid-1;
            }
        }
        return -1;
    }
}
