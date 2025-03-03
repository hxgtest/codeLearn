package hot100and150.动态规划;

/**
 * @author 12293
 * @description: 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * @date 2025/3/3 10:19
 */
public class 最长递增子序列 {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        dp[0]=1;
        int max=1;
        for(int i=1;i<n;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }
    public int lengthOfLIS1(int[] nums) {
        int len=1,n=nums.length;
        if(n==0){
            return 0;
        }
        int[] d=new int[n+1];
        d[len]=nums[0];
        for(int i=1;i<n;i++){
            if(nums[i]>d[len]){
                d[++len]=nums[i];
            }else {
                int l=1,r=len,pos=0;
                while (l<=r){
                    int mid=l+(r-l)/2;
                    if(d[mid]<nums[i]){
                        pos=mid;
                        l=mid+1;
                    }else {
                        r=mid-1;
                    }
                }
                d[pos+1]=nums[i];
            }
        }
        return len;
    }

    }
