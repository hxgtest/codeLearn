package hot100second.贪心算法;

import java.util.Arrays;

/**
 * @author 12293
 * @description: TODO
 * @date 2025/4/8 10:25
 */
public class 跳跃游戏Ⅱ {
    public int jump(int[] nums) {
        int n=nums.length;
        int side=0;
        int end=0;
        int step=0;
        for(int i=0;i<n-1;i++){
            side=Math.max(i+nums[i],side);
            if(i==end){
                end=side;
                step++;
            }
        }
        return step;
    }
}
