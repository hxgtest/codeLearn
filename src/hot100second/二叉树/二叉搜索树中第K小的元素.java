package hot100second.二叉树;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hxg
 * @description: TODO
 * @date 2025/3/18 10:50
 */
public class 二叉搜索树中第K小的元素 {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack=new ArrayDeque<>();
        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            k--;
            if(k==0){
                break;
            }
            root=root.right;
        }
        return root.val;
    }
    class MyBst{
        TreeNode root;
        Map<TreeNode,Integer> nodeNum;
        public MyBst(TreeNode root){
            this.root=root;
            this.nodeNum=new HashMap<>();
            countNodeNum(root);
        }
        private int kthSmallest(int k){
            TreeNode node=root;
            while (node!=null){
                int left=getNodeNum(node.left);
                if(left<k-1){
                    node=node.right;
                    k-=left+1;
                }else if(left==k-1){
                    break;
                }else {
                    node=node.left;
                }
            }
            return node.val;
        }
        private int countNodeNum(TreeNode node){
            if(node==null){
                return 0;
            }
            nodeNum.put(node,1+countNodeNum(node.left)+countNodeNum(node.right));
            return nodeNum.get(node);
        }
        private int getNodeNum(TreeNode node){
            return nodeNum.getOrDefault(node,0);
        }
    }
}
