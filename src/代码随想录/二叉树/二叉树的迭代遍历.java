package 代码随想录.二叉树;

import java.lang.reflect.Method;
import java.util.*;

public class 二叉树的迭代遍历 {
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> ans=new ArrayList<>();
        if(root==null){
            return new ArrayList<>();
        }
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node=stack.pop();
            ans.add(node.val);
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }
        }
        return ans;
    }
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> ans=new ArrayList<>();
        if(root==null){
            return new ArrayList<>();
        }
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        while(!stack.isEmpty()||cur!=null){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            TreeNode node=stack.pop();
            ans.add(node.val);
            if(node.right!=null){
                cur=node.right;
            }
        }
        return ans;
    }
    public List<Integer> postorderTraversal(TreeNode root){
        //左 右 中
        //前序换个方向再倒过来
        List<Integer> ans=new ArrayList<>();
        if(root==null){
            return new ArrayList<>();
        }
        Stack<TreeNode> stack1=new Stack<>();
        stack1.push(root);

        while(!stack1.isEmpty()){
            TreeNode node=stack1.pop();
            ans.add(node.val);

            if(node.left!=null){
                stack1.push(node.left);
            }
            if(node.right!=null){
                stack1.push(node.right);
            }
        }
        Collections.reverse(ans);
        return ans;
    }
    public List<Integer> postorderTraversal1(TreeNode root){
        List<Integer> res=new ArrayList<>();
        if(root==null){
            return res;
        }
        Deque<TreeNode> stack=new ArrayDeque<>();
        TreeNode prev=null;
        while(root!=null||!stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            if(root.right==null||root.right==prev){
                res.add(root.val);
                prev=root;
                root=null;
            }else {
                stack.push(root);
                root=root.right;
            }
        }
        return res;
    }
}
