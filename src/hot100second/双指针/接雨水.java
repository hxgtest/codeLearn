package hot100second.双指针;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author 12293
 * @description: 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * @date 2025/3/7 13:34
 */
public class 接雨水 {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }
        int[] leftMax = new int[n];
        leftMax[0]=height[0];
        for(int i=1;i<n;i++){
            leftMax[i]=Math.max(leftMax[i-1],height[i]);
        }
        int[] rightMax=new int[n];
        rightMax[n-1]=height[n-1];
        for (int i=n-2;i>=0;i--){
            rightMax[i]=Math.max(rightMax[i+1],height[i]);
        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans+=Math.min(leftMax[i],rightMax[i])-height[i];
        }
        return ans;
    }
    public int trap1(int[] height) {
        int n=height.length;
        int ans=0;
        int left=0,right=n-1;
        int leftMax=0,rightMax=0;
        while(left<right){
            leftMax=Math.max(leftMax,height[left]);
            rightMax=Math.max(rightMax,height[right]);
            if(height[left]<height[right]){
                ans+=leftMax-height[left];
                left++;
            }else {
                ans+=rightMax-height[rightMax];
                right--;
            }
        }
        return ans;
    }
    public int trap2(int[] height) {
        int ans=0;
        Deque<Integer> stack=new LinkedList<>();
        int n=height.length;
        for (int i=0;i<n;i++){
            while(!stack.isEmpty()&&height[i]>height[stack.peek()]){
                int top=stack.pop();
                if(stack.isEmpty()){
                    break;
                }
                int left=stack.peek();
                int curWidth=i-left-1;
                int curHeight=Math.min(height[left],height[i])-height[top];
                ans+=curHeight*curWidth;
            }
            stack.push(i);
        }
        return ans;
    }
}
