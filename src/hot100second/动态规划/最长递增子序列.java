package hot100second.动态规划;

/**
 * @author 12293
 * @description: TODO
 * @date 2025/4/13 16:19
 */
public class 最长递增子序列 {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        if(n==0){
            return 0;
        }
        int[] dp=new int[n];
        dp[0]=1;
        int max=0;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }
    public int lengthOfLIS1(int[] nums){
        int len=1;
        int n=nums.length;
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
                    int mid=(l+r)>>1;
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
