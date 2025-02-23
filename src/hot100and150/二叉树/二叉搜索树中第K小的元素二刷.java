package hot100and150.二叉树;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author hxg
 * @description: TODO
 * @date 2025/2/23 10:20
 */
public class 二叉搜索树中第K小的元素二刷 {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack=new ArrayDeque<>();
        while (root!=null||!stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            --k;
            if(k==0){
                break;
            }
            root=root.right;
        }
        return root.val;
    }
    private int k;
    private int kthSmallest1(TreeNode root,int k){
        this.k=k;
        return dfs(root);
    }
    private int dfs(TreeNode node){
        if(node==null){
            return -1;
        }
        int leftRes=dfs(node.left);
        if(leftRes!=-1){
            return leftRes;
        }
        if(--k==0){
            return node.val;
        }
        return dfs(node.right);
    }
}
