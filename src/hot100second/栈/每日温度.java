package hot100second.栈;

import java.util.Stack;

/**
 * @author 12293
 * @description: TODO
 * @date 2025/4/1 18:46
 */
public class 每日温度 {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack=new Stack<>();
        int[] ans=new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++){
            int temperature=temperatures[i];
            while (!stack.isEmpty()&&temperatures[stack.peek()]<temperature){
                int pre=stack.pop();
                ans[pre]=i-pre;
            }
            stack.push(i);
        }
        return ans;
    }
}
