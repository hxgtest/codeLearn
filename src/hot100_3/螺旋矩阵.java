package hot100_3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hxg
 * @description: TODO
 * @date 2025/8/26 21:07
 */
public class 螺旋矩阵 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int left=0,right=matrix[0].length-1,top=0,bottom=matrix.length-1;
        List<Integer> ans=new ArrayList<>();
        while (left<=right||top<=bottom){
            for(int j = left; j <=right; j++){
                ans.add(matrix[top][j]);
            }
            for(int i=top+1;i<=bottom;i++){
                ans.add(matrix[i][right]);
            }
            for(int j=right-1;j>=left;j--){
                ans.add(matrix[bottom][j]);
            }
            for(int i=bottom-1;i>=top;i--){
                ans.add(matrix[i][left]);
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return ans;
    }
}
