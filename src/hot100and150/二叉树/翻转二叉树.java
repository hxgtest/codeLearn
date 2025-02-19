package hot100and150.二叉树;

/**
 * @author 12293
 * @description: TODO
 * @date 2025/2/19 10:00
 */
public class 翻转二叉树 {
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        if(root.left==null&&root.right==null){
            return root;
        }
        TreeNode left=root.left;
        root.left=invertTree(root.right);
        root.right=invertTree(left);
        return root;
    }
}
