package hot100and150.矩阵;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hxg
 * @description: 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素
 * @date 2025/2/13 13:43
 */
public class 螺旋矩阵二刷 {
    //模拟
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order=new ArrayList<>();
        int rows=matrix.length,columns=matrix[0].length;
        int[][] directions={{0,1},{1,0},{0,-1},{-1,0}};
        int total=rows*columns;
        boolean[][] visited=new boolean[rows][columns];
        int directionIndex=0;
        int row=0,column=0;
        for(int i=0;i<total;i++){
            order.add(matrix[row][column]);
            visited[row][column]=true;
            int nextRow=row+directions[directionIndex][0],nextColumn=column+directions[directionIndex][1];
            if(nextRow<0||nextRow>=rows||nextColumn<0||nextColumn>=columns||visited[nextRow][nextColumn]){
                directionIndex=(directionIndex+1)%4;
            }
            row=row+directions[directionIndex][0];
            column=column+directions[directionIndex][1];
        }
        return order;
    }
    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> order=new ArrayList<>();
        int top=0,bottom=matrix.length-1,left=0,right=matrix[0].length-1;
        while(top<=bottom&&left<=right){
            for(int column = left; column <=right; column++){
                order.add(matrix[top][column]);
            }
            for(int row = top+1; row <=bottom;row++){
                order.add(matrix[row][right]);
            }
            for(int column=right-1;column>=left;column--){
                order.add(matrix[bottom][column]);
            }
            for(int row=bottom-1;row>=top+1;row--){
                order.add(matrix[row][left]);
            }
            top++;
            bottom--;
            left++;
            right--;
        }
        return order;
    }
}
