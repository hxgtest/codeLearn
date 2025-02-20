package hot100and150.二叉树;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author hxg
 * @description: 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 * @date 2025/2/20 10:41
 */
public class 从前序和中序遍历构造二叉树 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen=preorder.length;
        int inLen=inorder.length;

        Map<Integer,Integer> map=new HashMap<>(preLen);
        for(int i=0;i<inLen;i++){
            map.put(inorder[i],i);
        }

        return buildTree(preorder,0,preLen-1,map,0,inLen-1);
    }
    public TreeNode buildTree(int[] preorder,int preLeft,int preRight,Map<Integer,Integer> map,int inLeft,int inRight){
        if(preLeft>preRight||inLeft>inRight){
            return null;
        }
        int rootVal=preorder[preLeft];
        TreeNode root=new TreeNode(rootVal);
        int pIndex=map.get(rootVal);

        root.left=buildTree(preorder,preLeft+1,pIndex-inLeft+preLeft,map,inLeft,pIndex-1);
        root.right=buildTree(preorder,pIndex-inLeft+preLeft+1,preRight,map,pIndex+1,inRight);
        return root;
    }
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        if(preorder==null||preorder.length==0){
            return null;
        }
        TreeNode root=new TreeNode(preorder[0]);
        Deque<TreeNode> stack=new LinkedList<>();
        stack.push(root);
        int inorderIndex=0;
        for (int i=1;i<preorder.length;i++){
            int preorderVal=preorder[i];
            TreeNode node=stack.peek();
            if(node.val!=inorder[inorderIndex]){
                node.left=new TreeNode(preorderVal);
                stack.push(node.left);
            }else {
                while(!stack.isEmpty()&&stack.peek().val==inorder[inorderIndex]){
                    node=stack.pop();
                    inorderIndex++;
                }
                node.right=new TreeNode(preorderVal);
                stack.push(node.right);

            }
        }
        return root;
    }
}
