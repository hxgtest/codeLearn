package 代码随想录.二叉树;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 二叉树的右视图 {
    public List<Integer> rightSideView(TreeNode root){
        List<Integer> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        Deque<TreeNode> stack=new ArrayDeque<>();
        stack.addLast(root);
        while(!stack.isEmpty()){
            int len=stack.size();
            for(int i=0;i<len;i++){
                TreeNode node=stack.removeFirst();
                if(node.left!=null){
                    stack.addLast(node.left);
                }
                if(node.right!=null){
                    stack.addLast(node.right);
                }
                if(i==len-1){
                    ans.add(node.val);
                }
            }
        }
        return ans;
    }
}
