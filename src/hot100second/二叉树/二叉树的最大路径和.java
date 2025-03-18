package hot100second.二叉树;

/**
 * @author 12293
 * @description: TODO
 * @date 2025/3/18 16:36
 */
public class 二叉树的最大路径和 {
    int maxSum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        caculateMax(root);
        return maxSum;


    }
    public int caculateMax(TreeNode root){
        if(root==null){
            return 0;
        }

        int maxL=Math.max(caculateMax(root.left),0);
        int maxR=Math.max(caculateMax(root.right),0);
        int pathSum=root.val+maxL+maxR;
        maxSum=Math.max(maxSum,pathSum);
        return root.val+Math.max(maxL,maxR);
    }
}
