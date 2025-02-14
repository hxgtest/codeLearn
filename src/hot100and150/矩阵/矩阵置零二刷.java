package hot100and150.矩阵;

/**
 * @author 12293
 * @description: 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法
 * @date 2025/2/14 14:52
 */
public class 矩阵置零二刷 {
    public void setZeroes(int[][] matrix){
        boolean rowZero=false,columnZero=false;
        for(int i=0;i<matrix.length;i++){
            if (matrix[i][0] == 0) {
                columnZero = true;
                break;
            }
        }
        for(int j = 0; j <matrix[0].length; j++){
            if (matrix[0][j] == 0) {
                rowZero = true;
                break;
            }
        }


        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        for(int i=1;i<matrix.length;i++){
            if(matrix[i][0]==0){
                for(int j=1;j<matrix[0].length;j++){
                    matrix[i][j]=0;
                }
            }
        }
        for(int j = 1; j <matrix[0].length; j++){
            if(matrix[0][j]==0){
                for(int i = 1; i <matrix.length; i++){
                    matrix[i][j]=0;
                }
            }
        }
        if(rowZero){
            for(int j=0;j<matrix[0].length;j++){
                matrix[0][j]=0;
            }
        }
        if(columnZero){
            for(int i=0;i<matrix.length;i++){
                matrix[i][0]=0;
            }
        }
    }
}
