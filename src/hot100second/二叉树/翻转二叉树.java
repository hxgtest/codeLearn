package hot100second.二叉树;

/**
 * @author hxg
 * @description: 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 *
 *
 * @date 2025/3/17 23:55
 */
public class 翻转二叉树 {
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        if(root.left==null&&root.right==null){
            return root;
        }
        TreeNode temp=root.left;
        root.left=invertTree(root.right);
        root.right=invertTree(temp);
        return root;
    }
}
