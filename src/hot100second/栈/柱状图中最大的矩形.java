package hot100second.栈;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author 12293
 * @description: TODO
 * @date 2025/4/1 18:57
 */
public class 柱状图中最大的矩形 {
    public int largestRectangleArea(int[] heights) {
        int len=heights.length;
        if(len==0){
            return 0;
        }
        if(len==1){
            return heights[0];
        }
        int res=0;
        int[] newHeights=new int[len+2];
        newHeights[0]=0;
        System.arraycopy(heights,0,newHeights,1,len);
        newHeights[len+1]=0;
        len+=2;
        heights=newHeights;

        Deque<Integer> stack=new ArrayDeque<>(len);
        stack.addLast(0);
        for (int i=1;i<len;i++){
            while (heights[i]<heights[stack.peekLast()]){
                int curHeight=heights[stack.pollLast()];
                int curWidth=i-stack.peekLast()-1;
                res=Math.max(res,curWidth*curHeight);
            }
            stack.addLast(i);
        }
        return res;
    }
}
