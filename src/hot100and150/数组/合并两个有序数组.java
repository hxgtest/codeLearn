package hot100and150.数组;

/**
 * @author 12293
 * @description: 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 * @date 2025/1/18 20:14
 */
public class 合并两个有序数组 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] ans=new int[m+n];
        int ptr1=0,ptr2=0;
        int i=0;
        while(ptr1<m||ptr2<n){
            if(ptr1==m){
                ans[i++]=nums2[ptr2++];
            }else if(ptr2==n){
                ans[i++]=nums1[ptr1++];
            }else if(nums1[ptr1]<nums2[ptr2]){
                ans[i++]=nums1[ptr1++];
            }else {
                ans[i++]=nums2[ptr2++];
            }
        }
        for(int j=0;j<m+n;j++){
            nums1[j]=ans[j];
        }
    }
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] ans=new int[m+n];
        int ptr1=m-1,ptr2=n-1;
        int i=m+n-1;
        while(ptr1>=0||ptr2>=0){
            if(ptr1==-1){
                nums1[ptr1+ptr2-1]=nums2[ptr2--];
            }else if(ptr2==-1){
                nums1[ptr1+ptr2-1]=nums1[ptr1--];
            }else if(nums1[ptr1]>nums2[ptr2]){
                nums1[ptr1+ptr2-1]=nums1[ptr1--];
            }else {
                nums1[ptr1+ptr2-1]=nums2[ptr2--];
            }
        }
    }
}
