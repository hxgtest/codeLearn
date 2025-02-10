package hot100and150.数组;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author hxg
 * @description: 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * @date 2025/2/10 11:37
 */
public class 接雨水 {
    public int trap1(int[] height) {
        //方法1：动态规划
        //对于下表i，该处能接到的雨水量=两边最大高度的较小值
        int n=height.length;
        int[] left=new int[n];
        int[] right=new int[n];
        left[0]=height[0];
        right[n-1]=height[n-1];
        for(int i=1;i<n;i++){
            left[i]=Math.max(left[i-1],height[i]);
        }
        for(int i=n-2;i>=0;i--){
            right[i]=Math.max(right[i+1],height[i]);
        }
        int rain=0;
        for(int i=0;i<n;i++){
            rain+=Math.min(left[i],right[i])-height[i];
        }
        return rain;
    }
    public int trap2(int[] height){
        //方法2：单调栈
        Deque<Integer> stack=new ArrayDeque<>();
        int rain=0;
        for(int i=0;i<height.length;i++){
            while(!stack.isEmpty()&&height[i]>height[stack.peek()]){
                int top=stack.pop();
                if(stack.isEmpty()){
                    break;
                }
                int left=stack.peek();
                int currWidth=i-left-1;
                int currHeight=Math.min(height[left],height[i])-height[top];
                rain+=currHeight*currWidth;
            }
            stack.push(i);

        }
        return rain;
    }
    public int trap3(int[] height){
        //方法3双指针
        int rain=0;
        int left=0,right=height.length-1;
        int leftMax=0,rightMax=0;
        while (left<right){
            leftMax=Math.max(leftMax,height[left]);
            rightMax=Math.max(rightMax,height[right]);
            if(height[left]<height[right]){
                rain+=leftMax-height[left];
                left++;
            }else {
                rain+=rightMax-height[right];
                right--;
            }
        }
        return rain;
    }
}
