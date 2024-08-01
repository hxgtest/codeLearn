package 代码随想录.动态规划;
//给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
//
//
//
//示例 1：
//
//输入：nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
//输出：3
//解释：长度最长的公共子数组是 [3,2,1] 。
//示例 2：
//
//输入：nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
//输出：5
//
//
//提示：
//
//        1 <= nums1.length, nums2.length <= 1000
//        0 <= nums1[i], nums2[i] <= 100
public class 最长重复子数组 {
    class Solution {
        public int findLength(int[] nums1,int[] nums2){
            int n1=nums1.length,n2=nums2.length;
            int[][] dp=new int[n1][n2];
            int max=0;
            for(int i=0;i<n1;i++){
                if(nums1[i]==nums2[0]){
                    dp[i][0]=1;
                    max=1;
                }
            }
            for(int i=0;i<n2;i++){
                if(nums1[0]==nums2[i]){
                    dp[0][i]=1;
                    max=1;
                }
            }

            for(int i=1;i<n1;i++){
                for(int j=1;j<n2;j++){
                    if(nums1[i]==nums2[j]){
                        dp[i][j]=dp[i-1][j-1]+1;
                    }else {
                        dp[i][j]=0;
                    }
                    max=Math.max(max,dp[i][j]);
                }
            }
            return max;
        }
    }
}
