package hot100second.技巧;

/**
 * @author 12293
 * @description: TODO
 * @date 2025/3/19 15:47
 */
public class 颜色分类 {
    public void sortColors(int[] nums) {
        int n=nums.length;
        int p0=0,p2=n-1;
        for(int i=0;i<=p2;i++){
            while (i<=p2&&nums[i]==2){
                int tmp=nums[i];
                nums[i]=nums[p2];
                nums[p2]=tmp;
                p2--;
            }
            if(nums[i]==0){
                int tmp=nums[i];
                nums[i]=nums[p0];
                nums[p0]=tmp;
                p0++;
            }
        }
    }
    public void swap(int[] nums,int index1,int index2){
        int temp=nums[index1];
        nums[index1]=nums[index2];
        nums[index2]=temp;
    }
}
