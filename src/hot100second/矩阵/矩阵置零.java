package hot100second.矩阵;

/**
 * @author 12293
 * @description: TODO
 * @date 2025/3/10 09:13
 */
public class 矩阵置零 {
    public void setZeroes(int[][] matrix) {
        boolean rowZero=false,columnZero=false;
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][0]==0){
                columnZero=true;
            }
        }
        for(int j=0;j<matrix[0].length;j++){
            if(matrix[0][j]==0){
                rowZero=true;
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
            if (matrix[i][0]==0){
                for(int j=1;j<matrix[0].length;j++){
                    matrix[i][j]=0;
                }
            }
        }
        for(int j = 1; j <matrix[0].length; j++){
            if (matrix[0][j]==0){
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
            for(int i = 0; i <matrix.length; i++){
                matrix[0][i]=0;
            }
        }
    }
}
