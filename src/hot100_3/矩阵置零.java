package hot100_3;

/**
 * @author hxg
 * @description: TODO
 * @date 2025/8/26 21:00
 */
public class 矩阵置零 {
    public void setZeroes(int[][] matrix) {
        for(int i=1;i<matrix.length;i++){
            for (int j=1;j<matrix[0].length;j++){
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
        for(int j = 1; j<matrix[0].length; j++){
            if(matrix[0][j]==0){
                for(int i=1;i<matrix.length;i++){
                    matrix[i][j]=0;
                }
            }
        }
        if(matrix[0][0]==0){
            for(int i=1;i<matrix.length;i++){
                if(matrix[i][0]==0){
                    for(int j=1;j<matrix[0].length;j++){
                        matrix[i][j]=0;
                    }
                }
            }
            for(int j = 1; j<matrix[0].length; j++){
                if(matrix[0][j]==0){
                    for(int i=1;i<matrix.length;i++){
                        matrix[i][j]=0;
                    }
                }
            }
        }
    }
}
