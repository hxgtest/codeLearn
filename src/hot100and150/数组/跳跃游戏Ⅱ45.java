package hot100and150.数组;

/**
 * @author hxg
 * @description: 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 *
 * 每个元素 nums[i] 表示从索引 i 向后跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 *
 * 0 <= j <= nums[i]
 * i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 * @date 2025/2/8 16:48
 */
public class 跳跃游戏Ⅱ45 {
    public int jump1(int[] nums) {

        int position=nums.length-1;
        int step=0;
        while (position>0){
            for(int i=0;i<position;i++){
                if(i+nums[i]>=position){
                    step++;
                    position=i;
                    break;
                }
            }
        }
        return step;

    }
    public int jump2(int[] nums){
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;

    }
}
