package hot100second.二分查找;

/**
 * @author 12293
 * @description: TODO
 * @date 2025/3/28 13:16
 */
public class 寻找两个正序数组的中位数 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1=nums1.length,l2=nums2.length;
        int sum=l1+l2;
        if(sum%2==1){
            int midIndex=sum/2;
            double median=getKthElement(nums1,nums2,midIndex+1);
            return median;
        }else {
            int midIndex1=sum/2-1,midIndex2=sum/2;
            double median=(getKthElement(nums1,nums2,midIndex1+1)+getKthElement(nums1,nums2,midIndex2+1));
            return median;
        }
    }
    public int getKthElement(int[] nums1,int[] nums2,int k){
        int l1=nums1.length,l2=nums2.length;
        int index1=0,index2=0;
        int kthElement=0;
        while (true){
            if(index1==l1){
                return nums2[index2+k-1];
            }
            if(index2==l2){
                return nums1[index1+k-1];
            }
            if(k==1){
                return Math.min(nums1[index1],nums2[index2]);
            }
            int half=k/2;
            int newIndex1=Math.min(index1+half,l1)-1;
            int newIndex2=Math.min(index2+half,l2)-1;
            int p1=nums1[newIndex1],p2=nums2[newIndex2];
            if(p1<=p2){
                k-=(newIndex1-index1+1);
                index1=newIndex1+1;
            }else {
                k-=(newIndex2-index2+1);
                index2=newIndex2+1;
            }
        }
    }
}
