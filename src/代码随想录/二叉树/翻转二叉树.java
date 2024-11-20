package 代码随想录.二叉树;

public class 翻转二叉树 {
    public TreeNode invertTree(TreeNode root){
        if(root==null||(root.left==null&&root.right==null)){
            return root;
        }
        TreeNode right=invertTree(root.right);
        TreeNode left=invertTree(root.left);
        root.left=right;
        root.right=left;
        return root;
    }
}
