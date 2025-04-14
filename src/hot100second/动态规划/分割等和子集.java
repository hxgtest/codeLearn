package hot100second.动态规划;

/**
 * @author 12293
 * @description: TODO
 * @date 2025/4/14 10:18
 */
public class 分割等和子集 {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        if(n<2){
            return false;
        }
        int sum=0,max=0;
        for(int num:nums){
            sum+=num;
            max=Math.max(max,num);
        }
        if(sum%2==1){
            return false;
        }
        int target=sum/2;
        if(max>target){
            return false;
        }
        boolean[][] dp=new boolean[n][target+1];
        for(int i=0;i<n;i++){
            dp[i][0]=true;
        }
        dp[0][nums[0]]=true;
        for(int i=1;i<n;i++){
            int num=nums[i];
            for(int j=1;j<target+1;j++){
                if(j>=nums[i]){
                    dp[i][j]=dp[i-1][j]|dp[i-1][j-nums[i]];
                }else {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n-1][target];
    }
}
