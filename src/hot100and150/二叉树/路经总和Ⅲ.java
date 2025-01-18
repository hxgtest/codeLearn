package hot100and150.二叉树;

import java.util.HashMap;
import java.util.Map;

public class 路经总和Ⅲ {
    public int pathSum(TreeNode root,int targetSum){
        if(root==null){
            return 0;
        }
        int ret=rootSum(root,targetSum);
        ret+=pathSum(root.left,targetSum);
        ret+=pathSum(root.right,targetSum);
        return ret;
    }
    public int rootSum(TreeNode root,int targetSum){
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
    private int ans;
    public int pathSum1(TreeNode root,int targetSum){
        Map<Long,Integer> cnt=new HashMap<>();
        cnt.put(0L,1);
        dfs(root,0,targetSum,cnt);
        return ans;
    }
    private void dfs(TreeNode node, long s, int targetSum, Map<Long,Integer> cnt){
        if(node==null){
            return;
        }
        s+=node.val;
        ans+=cnt.getOrDefault(s-targetSum,0);
        cnt.merge(s,1,Integer::sum);
        dfs(node.left,s,targetSum,cnt);
        dfs(node.right,s,targetSum,cnt);
        cnt.merge(s,-1,Integer::sum);//恢复现场
    }
}
