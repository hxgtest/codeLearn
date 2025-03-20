package hot100second.回溯法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 12293
 * @description: TODO
 * @date 2025/3/20 10:00
 */
public class 组合总和 {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);
        backtrack(candidates,target,0,new ArrayList<>());
        return ans;
    }
    public void backtrack(int[] candidates,int target,int index,List<Integer> list){
        if(index==candidates.length){
            return;
        }
        if(target==0){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(target-candidates[index]>=0){
            list.add(candidates[index]);
            backtrack(candidates,target-candidates[index],index,list);
            list.remove(list.size()-1);
        }

        backtrack(candidates,target,index+1,list);
    }
}
