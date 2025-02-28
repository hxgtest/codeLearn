package hot100and150.堆;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author hxg
 * @description: 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * @date 2025/2/27 11:17
 */
public class 数组中的第K个最大元素二刷 {
    public int findKthLargest(int[] nums, int k) {
        int heapSize=nums.length;
        buildMaxHeap(nums,heapSize);
        for(int i=nums.length-1;i>=nums.length-k+1;i--){
            swap(nums,0,i);
            --heapSize;
            maxHeapify(nums,0,heapSize);
        }
        return nums[0];
    }
    public void buildMaxHeap(int[] a,int heapSize){
        for(int i=heapSize/2-1;i>=0;i--){
            maxHeapify(a,i,heapSize);
        }
    }
    public void maxHeapify(int[] a,int i,int heapSize){
        int l=i*2+1,r=i*2+2,largest=i;
        if(l<heapSize&&a[l]>a[largest]){
            largest=l;
        }
        if(r<heapSize&&a[r]>a[largest]){
            largest=r;
        }
        if(largest!=i){
            swap(a,i,largest);
            maxHeapify(a,largest,heapSize);
        }
    }
    public void swap(int[] a,int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    public int quickselect(List<Integer> nums,int k){
        Random rand=new Random();
        int pivot= nums.get(rand.nextInt(nums.size()));

        List<Integer> big=new ArrayList<>();
        List<Integer> equal=new ArrayList<>();
        List<Integer> small=new ArrayList<>();

        for(int num:nums){
            if(num>pivot){
                big.add(num);
            }else if(num<pivot){
                small.add(num);
            }else {
                equal.add(num);
            }
        }
        if(k<=big.size()){
            return quickselect(big,k);
        }
        if(nums.size()-small.size()<k){
            return quickselect(small,k-nums.size()+small.size());
        }
        return pivot;
    }
}
