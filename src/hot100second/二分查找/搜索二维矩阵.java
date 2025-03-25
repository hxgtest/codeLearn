package hot100second.二分查找;

/**
 * @author 12293
 * @description: TODO
 * @date 2025/3/25 10:51
 */
public class 搜索二维矩阵 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length,n=matrix[0].length;
        int top=0,bottom=m-1;
        while (top<bottom){
            int mid=top+(bottom-top+1)/2;
            if(matrix[mid][0]==target){
                return true;
            }
            if(matrix[mid][0]>target){
                bottom=mid-1;
            }else {
                top=mid;
            }
        }
        if(top<0){
            return false;
        }
        int left=0,right=n-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            if(matrix[top][mid]==target){
                return true;
            }else if(matrix[top][mid]>target){
                right=mid-1;
            }else {
                left=mid+1;
            }
        }
        return false;
    }
}
