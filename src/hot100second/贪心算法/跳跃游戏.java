package hot100second.贪心算法;

import java.util.Stack;

/**
 * @author 12293
 * @description: TODO
 * @date 2025/4/4 21:02
 */
public class 跳跃游戏 {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        int side=0;
        for(int i=0;i<n;i++){
            side=Math.max(side,i+nums[i]);
            if(side>=n-1){
                return true;
            }
        }
        return false;
    }
}
