package hot100and150.二叉树;

import java.util.HashMap;
import java.util.Map;

//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
public class 从前序和中序遍历序列构造二叉树 {
    private Map<Integer,Integer> indexMap;
    public TreeNode buildTree(int[] preorder,int[] inorder){
        //3 9 20 15 7
        //9 3 15 20 7
        int n=preorder.length;
        indexMap=new HashMap<>();
        for(int i=0;i<n;i++){
            indexMap.put(inorder[i],i);
        }
        return myBuildTree(preorder,inorder,0,n-1,0,n-1);
    }
    public TreeNode myBuildTree(int[] preorder,int[] inorder,int preorder_left,int preorder_right,int inorder_left,int inorder_right){
        if(preorder_left>preorder_right){
            return null;
        }

        //前序遍历中的第一个节点就是根节点
        int preorder_root=preorder_left;
        //在中序遍历中定位根节点
        int inorder_root=indexMap.get(preorder[preorder_root]);

        //建立根节点
        TreeNode root=new TreeNode(preorder[preorder_root]);
        //得到左子树中的节点数目
        int size_left_subtree=inorder_root-inorder_left;
        //递归构造左子树并连接到根节点
        root.left=myBuildTree(preorder,inorder,preorder_left+1,preorder_left+size_left_subtree,inorder_left,inorder_root-1);
        root.right=myBuildTree(preorder,inorder,preorder_left+size_left_subtree+1,preorder_right,inorder_root+1,inorder_right);
        return root;
    }
}
