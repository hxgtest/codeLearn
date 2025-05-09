package hot100second.技巧;

/**
 * @author 12293
 * @description: TODO
 * @date 2025/4/27 09:43
 */
public class 只出现一次的数字 {
    public int singleNumber(int[] nums) {
        int ans=nums[0];
        for(int i=1;i<nums.length;i++){
            ans^=nums[i];
        }
        return ans;
    }
}
