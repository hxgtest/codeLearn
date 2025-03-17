package hot100second.二叉树;

/**
 * @author hxg
 * @description: 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * @date 2025/3/17 23:58
 */
public class 对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        return check(root.left,root.right);
    }
    public boolean check(TreeNode left,TreeNode right){
        if(left==null&&right==null){
            return true;
        }
        if(left==null||right==null){
            return false;
        }
        if(left.val!=right.val){
            return false;
        }
        return check(left.left,right.right)&&check(left.right,right.left);
    }
}
