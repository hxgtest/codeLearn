package hot100and150.动态规划;

/**
 * @author hxg
 * @description: 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * @date 2025/3/2 11:31
 */
public class 打家劫舍 {
    public int rob(int[] nums) {
        int[] money=new int[nums.length+1];
        money[0]=0;
        money[1]=nums[0];
        for(int i=2;i<nums.length+1;i++){
            money[i]=Math.max(money[i-2]+nums[i-1],money[i-1]);
        }
        return money[nums.length];
    }
}
