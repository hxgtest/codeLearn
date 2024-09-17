package 代码随想录.数组;

/**
 * @author hxg
 * @description: TODO
 * @date 2024/9/17 16:09
 */
/*给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。*/
public class 螺旋矩阵Ⅱ {
    public int[][] generateMatrix(int n) {
        int[][] directions={{1,0},{0,1},{-1,0},{0,-1}};
        int[][] matrix=new int[n][n];
        int count=1;
        int row=0,column=0;
        int directionId=0;
        while(count<n*n){
            matrix[row][column]=count;
            count++;
            int nextRow=row+directions[directionId][0],nextColumn=column+directions[directionId][1];
            if(nextRow<0||nextRow>n||nextColumn<0||nextColumn>n||matrix[nextRow][nextColumn]!=0){
                directionId=(directionId+1)%4;
            }
            row=row+directions[directionId][0];
            column=column+directions[directionId][1];
        }
        return matrix;
    }
    public int[][] generateMatrix1(int n){
        int[][] matrix=new int[n][n];
        int round=0;
        int count=1,start=0;
        int i,j;
        while (round++<n/2){
            for(j=start;j<n-round;j++){
                matrix[start][j]=count++;
            }
            for(i=start;i<n-round;i++){
                matrix[i][j]=count++;
            }
            for(;j>=round;j--){
                matrix[i][j]=count++;
            }
            for(;i>=round;i--){
                matrix[i][j]=count++;
            }
            start++;

        }
        if(n%2==1){
            matrix[start][start]=count;
        }
        return matrix;
    }
}
