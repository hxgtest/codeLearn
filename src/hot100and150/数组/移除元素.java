package hot100and150.数组;

/**
 * @author 12293
 * @description: 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素。元素的顺序可能发生改变。然后返回 nums 中与 val 不同的元素的数量。
 * 假设 nums 中不等于 val 的元素数量为 k，要通过此题，您需要执行以下操作：
 * 更改 nums 数组，使 nums 的前 k 个元素包含不等于 val 的元素。nums 的其余元素和 nums 的大小并不重要。
 * 返回 k。
 * @date 2025/1/18 20:37
 */
public class 移除元素 {
    public int removeElement(int[] nums, int val) {
        int left=0,right=nums.length-1;
        while(right>=0&&nums[right]==val){
            right--;
        }
        while(left<=right){
            if(nums[left]==val){
                nums[left++]=nums[right];
                nums[right]=val;
                while(nums[right]==val){
                    right--;
                }
            }else{
                left++;
            }
        }


        return left;
    }
}
