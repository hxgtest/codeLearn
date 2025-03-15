package hot100second.二叉树;

import hot100second.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hxg
 * @description: TODO
 * @date 2025/3/15 16:58
 */
public class 中序遍历 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        inorder(ans,root);
        return ans;
    }
    public void inorder(List<Integer> ans,TreeNode root){
        if(root==null){
            return;
        }
        inorder(ans,root.left);
        ans.add(root.val);
        inorder(ans,root.right);
    }
}
