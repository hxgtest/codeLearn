package hot100and150.二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hxg
 * @description: TODO
 * @date 2025/2/22 17:45
 */
public class 二叉搜索树的最小绝对差 {
    public int getMinimumDifference(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        dfs(root,list);
        int min=Integer.MAX_VALUE;
        for(int i=1;i<list.size();i++){
            min=Math.min(min,Math.abs(list.get(i)-list.get(i-1)));
        }
        return min;
    }
    public void dfs(TreeNode root,List<Integer> list){
        if(root==null){
            return;
        }
        dfs(root.left,list);
        list.add(root.val);
        dfs(root.right,list);
    }
}
