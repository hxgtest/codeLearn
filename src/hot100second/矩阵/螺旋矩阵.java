package hot100second.矩阵;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 12293
 * @description: TODO
 * @date 2025/3/10 09:48
 */
public class 螺旋矩阵 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans=new ArrayList<>();
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return ans;
        }
        int rows=matrix.length,columns=matrix[0].length;
        boolean[][] visited=new boolean[rows][columns];
        int total=rows*columns;
        int row=0,column=0;
        int[][] directions={{0,1},{1,0},{0,-1},{-1,0}};
        int directionIndex=0;
        for(int i=0;i<total;i++){
            ans.add(matrix[row][column]);
            visited[row][column]=true;
            int newRow=row+directions[directionIndex][0],newColumn=column+directions[directionIndex][1];
            if(newRow>=rows||newRow<0||newColumn>=columns||newColumn<0||visited[newRow][newColumn]){
                directionIndex=(directionIndex+1)%4;
            }
            row+=directions[directionIndex][0];
            column+=directions[directionIndex][1];
        }
        return ans;

    }
}
