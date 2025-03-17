package hot100second.二叉树;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author hxg
 * @description: 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 * @date 2025/3/18 00:06
 */
public class 二叉树的层序遍历 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        Deque<TreeNode> deque=new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()){
            int len=deque.size();
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<len;i++){
                TreeNode node=deque.removeFirst();
                list.add(node.val);
                if(node.left!=null){
                    deque.addLast(node.left);
                }
                if(node.right!=null){
                    deque.addLast(node.right);
                }
            }
            ans.add(list);
        }
        return ans;
    }
}
