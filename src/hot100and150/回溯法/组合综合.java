package hot100and150.回溯法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hxg
 * @description: 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 *
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 *
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 * @date 2025/2/24 07:43
 */
public class 组合综合 {
    List<List<Integer>> ans=new ArrayList<>();
    List<Integer> t=new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        int sum=0;
        backtrack(candidates,target,0,sum,ans,t);
        return ans;
    }
    public void backtrack(int[] candidates,int target,int index,int sum,List<List<Integer>> ans,List<Integer> t){
        if(sum==target){
            ans.add(new ArrayList<>(t));
            return;
        }
        if(sum>target){
            return;
        }
        for (int i=index;i<candidates.length;i++){
            if(candidates[i]<=target){
                t.add(candidates[i]);
                sum+=candidates[i];
                backtrack(candidates,target-i,i,sum,ans,t);
                t.remove(t.size()-1);
                sum-=candidates[i];

            }
        }
    }

}
