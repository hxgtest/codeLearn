package hot100second.双指针;

/**
 * @author 12293
 * @description: TODO
 * @date 2025/3/7 12:55
 */
public class 盛最多水的容器 {
    public int maxArea(int[] height) {
        int left=0,right=height.length-1;
        int max=0;
        while (left<right){
            max=Math.max(max,Math.min(height[left],height[right])*(right-left));
            if(height[left]<height[right]){
                left++;
            }else {
                right--;
            }
        }
        return max;
    }
}
