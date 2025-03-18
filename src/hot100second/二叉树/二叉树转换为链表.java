package hot100second.二叉树;

/**
 * @author 12293
 * @description: TODO
 * @date 2025/3/18 13:23
 */
public class 二叉树转换为链表 {
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        TreeNode right=root.right!=null?root.right:null;
        if(root.left!=null){
            root.right=root.left;
            root.left=null;
            TreeNode node=root.right;
            while (node.right!=null){
                node=node.right;
            }
            node.right=right;
        }

        flatten(root.right);
    }
}
