package hot100second.二叉树;

/**
 * @author hxg
 * @description: TODO
 * @date 2025/3/15 17:12
 */
public class 二叉树的最大深度 {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
