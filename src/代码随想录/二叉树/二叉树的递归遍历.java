package 代码随想录.二叉树;

import java.util.ArrayList;
import java.util.List;

public class 二叉树的递归遍历 {
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> ans=new ArrayList<>();
        if(root!=null){
            ans.add(root.val);
            ans.addAll(preorderTraversal(root.left));
            ans.addAll(preorderTraversal(root.right));
        }
        return ans;
    }
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> ans=new ArrayList<>();
        if(root!=null){
            ans.addAll(preorderTraversal(root.left));
            ans.add(root.val);
            ans.addAll(preorderTraversal(root.right));
        }
        return ans;
    }
    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> ans=new ArrayList<>();
        if(root!=null){
            ans.addAll(preorderTraversal(root.left));
            ans.addAll(preorderTraversal(root.right));
            ans.add(root.val);
        }
        return ans;
    }
}
