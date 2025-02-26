package hot100and150.二分查找;

/**
 * @author 12293
 * @description: 给你一个满足下述两条属性的 m x n 整数矩阵：
 *
 * 每行中的整数从左到右按非严格递增顺序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
 * @date 2025/2/26 09:47
 */
public class 搜索二维矩阵二刷 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=binarySearchFirstColumn(matrix,target);
        if(m<0){
            return false;
        }
        return binarySearchRow(matrix[m],target);

    }
    public int binarySearchFirstColumn(int[][] matrix,int target){
        int l=-1,r=matrix.length-1;
        while (l<r){
            int mid=(r-l+1)/2+l;
            if(matrix[mid][0]>target){
                r=mid-1;
            }else {
                l=mid;
            }
        }
        return l;
    }
    public boolean binarySearchRow(int[] matrix,int target){
        int l=0,r=matrix.length-1;
        while (l<=r){
            int mid=(r-l)/2+l;
            if(matrix[mid]>target){
                r=mid-1;
            }else if(matrix[mid]<target){
                l=mid+1;
            }else if(matrix[mid]==target){
                return true;
            }
        }
        return false;
    }
}
