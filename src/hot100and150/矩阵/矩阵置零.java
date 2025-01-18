package hot100and150.矩阵;

//给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
//
//
//
//示例 1：
//
//
//输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
//输出：[[1,0,1],[0,0,0],[1,0,1]]
//示例 2：
//
//
//输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
//输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
//
//
//提示：
//
//m == matrix.length
//n == matrix[0].length
//1 <= m, n <= 200
//        -231 <= matrix[i][j] <= 231 - 1
//
//
//进阶：
//
//一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
//一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
//你能想出一个仅使用常量空间的解决方案吗？
public class 矩阵置零 {
    public void setZeroes1(int[][] matrix) {
        //一个直观的方法是建立一个m*n的数组来记录零的位置，并且对原矩阵每个零的位置进行置零操作
        int n=matrix[0].length,m=matrix.length;
        int[][] rec=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    rec[i][j]=1;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(rec[i][j]==1){
                    for(int k=0;k<m;k++){
                        matrix[k][j]=0;
                    }
                    for(int k=0;k<n;k++) {
                        matrix[i][k] = 0;
                    }
                }
            }
        }
        //
    }
    public void setZeroes2(int[][] matrix){
        //另一种想法是，既然置零操作会将当前行列置零，那么我们只需要记录要置零的行列即可，这样的时间复杂度就可以降低到O(m+n)
        int n=matrix[0].length,m=matrix.length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = col[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean flagCol0 = false, flagRow0 = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flagCol0 = true;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                flagRow0 = true;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (flagCol0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (flagRow0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}
