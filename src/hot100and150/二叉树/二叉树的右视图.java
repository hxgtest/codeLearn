package hot100and150.二叉树;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author hxg
 * @description: 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * @date 2025/2/22 17:30
 */
public class 二叉树的右视图 {
    public List<Integer> rightSideView(TreeNode root) {
        Deque<TreeNode> stack=new LinkedList<>();
        stack.addLast(root);
        List<Integer> ans=new LinkedList<>();
        if(root==null){
            return ans;
        }
        while (!stack.isEmpty()){
            int size=stack.size();
            ans.add(stack.peekLast().val);
            for(int i=0;i<size;i++){
                TreeNode node=stack.removeFirst();
                if(node.left!=null){
                    stack.addLast(node.left);
                }
                if(node.right!=null){
                    stack.addLast(node.right);
                }

            }
        }
        return ans;
    }
}
