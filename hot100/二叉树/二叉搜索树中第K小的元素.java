package hot100.二叉树;
//给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 小的元素（从 1 开始计数）。
public class 二叉搜索树中第K小的元素 {
    int sum;
    int ans;
    public int kthSmallest(TreeNode root,int k){
        //中序遍历
        sum=k;
        inOrder(root);
        return ans;
    }
    public void inOrder(TreeNode node){
        if(node==null){
            return;
        }
        inOrder(node.left);
        sum--;
        if(sum==0){
            ans=node.val;
            sum=Integer.MAX_VALUE;
        }
        inOrder(node.right);
    }
}
