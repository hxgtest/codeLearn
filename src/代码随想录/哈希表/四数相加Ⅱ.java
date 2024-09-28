package 代码随想录.哈希表;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hxg
 * @description: 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 * @date 2024/9/28 21:46
 */
public class 四数相加Ⅱ {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int n=nums1.length;
        Map<Integer,Integer> rec=new HashMap<>();
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int sum=-nums1[i]-nums2[j];
                rec.put(sum,rec.getOrDefault(sum,0)+1);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                ans+=rec.getOrDefault(nums3[i]+nums4[j],0);
            }
        }
        return ans;
    }
}
