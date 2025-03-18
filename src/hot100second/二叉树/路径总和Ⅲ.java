package hot100second.二叉树;

import java.util.Map;

/**
 * @author 12293
 * @description: TODO
 * @date 2025/3/18 16:05
 */
public class 路径总和Ⅲ {
    public int pathSum(TreeNode root, long targetSum) {
        if(root==null){
            return 0;
        }
        int ret=rootSum(root,targetSum);
        ret+=pathSum(root.left,targetSum);
        ret+=pathSum(root.right,targetSum);
        return ret;
    }
    public int rootSum(TreeNode root,long targetSum){
        int ret=0;
        if(root==null){
            return 0;
        }
        int val=root.val;
        if(val==targetSum){
            ret++;
        }
        ret+=rootSum(root.left,targetSum-val);
        ret+=rootSum(root.right,targetSum-val);
        return ret;
    }

    public int dfs(TreeNode root, Map<Long,Integer> prefix,long curr,int targetSum){
        if(root==null){
            return 0;
        }
        int ret=0;
        curr+=root.val;
        ret=prefix.getOrDefault(curr-targetSum,0);
        prefix.put(curr,prefix.getOrDefault(curr,0)+1);
        ret+=dfs(root.left,prefix,curr,targetSum);
        ret+=dfs(root.right,prefix,curr,targetSum);
        prefix.put(curr,prefix.getOrDefault(curr,0)-1);
        return ret;
    }
}
