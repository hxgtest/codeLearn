package hot100and150.二叉树;

/**
 * @author hxg
 * @description: 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 *
 * @date 2025/2/22 16:29
 */
public class 二叉树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        boolean leftp=exist(root.left,p);
        boolean leftq=exist(root.left,q);
        boolean rightp=exist(root.right,p);
        boolean rightq=exist(root.right,q);
        if((leftp&&rightq)||(leftq&&rightp)){
            return root;
        }
        if((root==p&&exist(root,q))||(root==q&&exist(root,p))){
            return root;
        }
        if(leftp&&leftq){
            return lowestCommonAncestor(root.left,p,q);
        }
        if(rightp&&rightq){
            return lowestCommonAncestor(root.right,p,q);
        }
        return null;
    }
    public boolean exist(TreeNode root,TreeNode node){
        if(root==null){
            return false;
        }
        if(root==node){
            return true;
        }else {
            return exist(root.left,node)||exist(root.right,node);
        }
    }
    //上面的做法太慢了
    public TreeNode ans=null;
    public boolean dfs(TreeNode root,TreeNode p,TreeNode q){
        if(root==null){
            return false;
        }
        boolean lson=dfs(root.left,p,q);
        boolean rson=dfs(root.right,p,q);
        if((lson&&rson)||((root.val==p.val||root.val==q.val)&&(lson||rson))){
            ans=root;
        }
        return lson||rson||(root.val==p.val||root.val==q.val);
    }
    public TreeNode lowestCommonAncestor1(TreeNode root,TreeNode p,TreeNode q){
        dfs(root,p,q);
        return ans;
    }
}
