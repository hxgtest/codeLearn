package 代码随想录.数组;

/**
 * @author hxg
 * @description: TODO
 * @date 2024/9/17 15:41
 */
/*给定一个含有 n 个正整数的数组和一个正整数 target 。

找出该数组中满足其总和大于等于 target 的长度最小的
        子数组
 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。*/
public class 长度最小的子数组 {
    public int minSubArrayLen(int target, int[] nums) {
        //滑动窗口
        int start = 0, end = 0, n = nums.length;
        int sum = 0;
        int minLen = n+1;
        while (end < n) {
            sum += nums[end];
            while (sum >= target) {
                minLen = Math.min(minLen, end - start + 1);
                sum -= nums[start++];
            }
            end++;
        }
        return minLen==n+1?0:minLen;
    }
}
