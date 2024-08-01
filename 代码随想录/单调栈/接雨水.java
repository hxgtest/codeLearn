package 代码随想录.单调栈;

import java.util.ArrayDeque;
import java.util.Deque;

//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
//
//
//示例 1：
//
//
//
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
//示例 2：
//
//输入：height = [4,2,0,3,2,5]
//输出：9
//
//
//提示：
//
//n == height.length
//1 <= n <= 2 * 104
//        0 <= height[i] <= 105
public class 接雨水 {
    static int trap(int[] height) {
        //定义一个单调栈
        int n = height.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] bigOrEqual = new int[n];
        int ans = 0;
        int curDepth=0,curWidth=0;
        for(int i=0;i<n;i++){

            while(!stack.isEmpty()&&height[stack.peek()]<height[i]){
                int top=stack.pop();
                if(stack.isEmpty()){
                    break;
                }
                int left=stack.peek();
                int width=i-left-1;
                int depth=Math.min(height[left],height[i])-height[top];
                ans+=width*depth;
            }
            stack.push(i);
        }
        return ans;
    }
    public static void main(String[] args){
        int[] height=new int[]{3,2,0,1,2,1,0,2,4};
        System.out.println(trap(height));
    }
}
