package hot100second.堆;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author 12293
 * @description: TODO
 * @date 2025/4/2 16:13
 */
public class 数组中的第K个最大元素 {
    public int findKthLargest(int[] nums, int k) {
        int n=nums.length;
        return quickSelect(nums,0,n-1,n-k);
    }
    int quickSelect(int[] nums,int l,int r,int k){
        if(l==r){
            return nums[k];
        }
        int x=nums[l],i=l-1,j=r+1;
        while (i<j){
            do {
                i++;
            }while (nums[i]<x);
            do {
                j--;
            }while (nums[j]>x);
            if(i<j){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
            }
        }
        if(k<=j){
            return quickSelect(nums,l,j,k);
        }else {
            return quickSelect(nums,j+1,l,k);
        }
    }
}
