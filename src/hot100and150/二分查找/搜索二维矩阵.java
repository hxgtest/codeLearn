package hot100and150.二分查找;
/*给你一个满足下述两条属性的 m x n 整数矩阵：

每行中的整数从左到右按非严格递增顺序排列。
每行的第一个整数大于前一行的最后一个整数。
给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。*/
public class 搜索二维矩阵 {
    public boolean searchMatrix(int[][] matrix,int target){
        int rows=matrix.length,columns=matrix[0].length;
        int l=0,r=rows-1;int mid=0;
        while (l<=r){
            mid=(l+r)/2;
            if(matrix[mid][0]==target){
                return true;
            }else if(matrix[mid][0]<target){
                l=mid+1;
            }else {
                r=mid-1;
            }
        }
        if(matrix[mid][0]>target){
            mid--;
            if(mid<0){
                return false;
            }
        }
        int row=mid;
        l=1;
        r=columns-1;
        while (l<=r){
            mid=(l+r)/2;
            if(matrix[row][mid]==target){
                return true;
            }else if(matrix[row][mid]<target){
                l=mid+1;
            }else {
                r=mid-1;
            }
        }
        return false;
    }
}
