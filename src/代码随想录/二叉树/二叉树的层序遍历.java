package 代码随想录.二叉树;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 二叉树的层序遍历 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        Deque<TreeNode> stack=new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()){
            int len=stack.size();
            List<Integer> level=new ArrayList<>();
            for(int i=0;i<len;i++){
                TreeNode node=stack.removeFirst();
                if(node.left!=null){
                    stack.addLast(node.left);
                }
                if(node.right!=null) {
                    stack.addLast(node.right);
                }
                level.add(node.val);
            }
            ans.add(level);
        }
        return ans;
    }
}
