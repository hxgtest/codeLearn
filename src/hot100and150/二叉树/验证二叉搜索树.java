package hot100and150.二叉树;

/**
 * @author hxg
 * @description: 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * 有效 二叉搜索树定义如下：
 *
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * @date 2025/2/23 10:36
 */
public class 验证二叉搜索树 {
    public boolean isValidBST(TreeNode root) {
        return isValid(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean isValid(TreeNode root,long left,long right){
        if(root==null){
            return true;
        }
        if(root.val<=left||root.val>=right){
            return false;
        }
        return isValid(root.left,left,root.val)&&isValid(root.right,root.val,right);
    }
}
