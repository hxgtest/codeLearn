package 代码随想录.单调栈;

import java.util.ArrayDeque;
import java.util.Deque;

public class 每日温度 {
    public int[] dailyTemperatures(int[] temperatures){
        int n=temperatures.length;
        int[] ans=new int[n];
        Deque<Integer> stack=new ArrayDeque<Integer>();
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty()&&temperatures[stack.peek()]<=temperatures[i]){
                stack.pop();
            }
            ans[i]=stack.isEmpty()?0:stack.peek()-i;
            stack.push(i);
        }

        return ans;
    }
}
