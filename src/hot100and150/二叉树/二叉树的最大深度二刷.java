package hot100and150.二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 12293
 * @description: 给定一个二叉树 root ，返回其最大深度。
 *
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 * @date 2025/2/19 09:43
 */
public class 二叉树的最大深度二刷 {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
    public int maxDepth1(TreeNode root){
        if(root==null){
            return 0;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int ans=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            while (size>0){
                TreeNode node=queue.poll();
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }
}
