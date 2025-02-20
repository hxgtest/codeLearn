package hot100and150.二叉树;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 12293
 * @description: 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 * @date 2025/2/20 14:06
 */
public class 从中序和后续遍历构造二叉树 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inLen=inorder.length;
        int postLen=postorder.length;
        Map<Integer,Integer> map=new HashMap<>(postLen);
        for(int i=0;i<inLen;i++){
            map.put(inorder[i],i);
        }
        return buildTree(postorder,0,postLen-1,map,0,inLen-1);
    }
    public TreeNode buildTree(int[] postorder, int postLeft, int postRight, Map<Integer,Integer> map,int inLeft,int inRight) {
        if(postLeft>postRight||inLeft>inRight){
            return null;
        }
        int rootVal=postorder[postRight];
        TreeNode root=new TreeNode(rootVal);
        int pIndex=map.get(rootVal);
        root.left=buildTree(postorder,postLeft,pIndex-inLeft+postLeft-1,map,inLeft,pIndex-1);
        root.right=buildTree(postorder,pIndex-inLeft+postLeft,postRight-1,map,pIndex+1,inRight);
        return root;
    }
}
