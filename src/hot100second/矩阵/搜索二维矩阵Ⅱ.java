package hot100second.矩阵;

/**
 * @author 12293
 * @description: TODO
 * @date 2025/3/11 09:23
 */
public class 搜索二维矩阵Ⅱ {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length,n=matrix[0].length;
        int x=0,y=0;
        while (x<m){
            for(y=n-1;y>=0;y--){
                while (x<m-1&&y>0&&matrix[x][y]>target){
                    x++;
                    y++;
                }
                if(matrix[x][y]==target){
                    return true;
                }
            }
            x++;
        }
        return false;
    }
    public boolean searchMatrix1(int[][] matrix, int target) {
        int m=matrix.length,n=matrix[0].length;
        int x=0,y=n-1;
        while (x<m&&y>=0){
            if(matrix[x][y]==target){
                return true;
            }
            if(matrix[x][y]>target){
                --y;
            }else {
                ++x;
            }
        }
        return false;
    }
}
