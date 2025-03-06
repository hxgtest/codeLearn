package hot100second.数组;

/**
 * @author 12293
 * @description: TODO
 * @date 2025/3/6 09:22
 */
public class 移动零 {
    public void moveZeroes(int[] nums) {
        if(nums.length==0){
            return;
        }
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[j++]=nums[i];
            }
        }
        for(int i=j;i<nums.length;i++){
            nums[i]=0;
        }

    }
}
