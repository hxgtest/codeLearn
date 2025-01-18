package hot100and150.数组;

/**
 * @author 12293
 * @description: 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * @date 2025/1/18 21:01
 */
public class 删除有序数组中的重复项2 {
    public int removeDuplicates(int[] nums) {
        //快慢指针
        int fast=0,slow=0;
        while(fast<nums.length){
            while(fast<nums.length-2&&nums[fast]==nums[fast+1]&&nums[fast]==nums[fast+2]){
                fast++;
            }
            nums[slow++]=nums[fast++];
        }
        return slow;
    }
}
