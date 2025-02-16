package hot100and150.区间;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hxg
 * @description: 给定一个  无重复元素 的 有序 整数数组 nums 。
 *
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 *
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 *
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 * @date 2025/2/16 09:14
 */
public class 汇总区间 {
    public List<String> summaryRanges(int[] nums) {
        int n=nums.length;
        int left=0,right=0;
        StringBuilder sb=new StringBuilder();
        List<String> ans=new ArrayList<>();
        while (right<n){
            while(right<n-1&&nums[right+1]==nums[right]+1){
                right++;
            }
            if(right==left){
                ans.add(String.valueOf(nums[left]));
            }else {
                sb.append(nums[left]).append("->").append(nums[right]);
                ans.add(sb.toString());
                sb.setLength(0);
            }
            left=right+1;
            right=left;
        }
        return ans;
    }
}
