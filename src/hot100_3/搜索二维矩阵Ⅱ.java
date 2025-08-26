package hot100_3;

/**
 * @author hxg
 * @description: TODO
 * @date 2025/8/26 21:44
 */
public class 搜索二维矩阵Ⅱ {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length,n=matrix[0].length;
        int x=0,y=n-1;
        while (x<m&&y>=0){
            if(matrix[x][y]==target){
                return true;
            }
            if(matrix[x][y]>target){
                y--;
            }else {
                x++;
            }
        }
        return false;
    }
}
