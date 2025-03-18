package hot100second.二叉树;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author hxg
 * @description: TODO
 * @date 2025/3/18 10:59
 */
public class 二叉树的右视图 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        Deque<TreeNode> queue=new ArrayDeque<>();
        queue.addLast(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode node=queue.removeFirst();
                if(i==0){
                    ans.add(node.val);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
                if(node.left!=null){
                    queue.add(node.left);
                }
            }
        }
        return ans;
    }
}
