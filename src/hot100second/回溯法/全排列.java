package hot100second.回溯法;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 12293
 * @description: TODO
 * @date 2025/3/20 09:15
 */
public class 全排列 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        Set<Integer> set=new HashSet<>();
        backtrack(nums,ans,list,set);
        return ans;

    }
    public void backtrack(int[] nums,List<List<Integer>> ans,List<Integer> list,Set<Integer> set){
        if(list.size()==nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i:nums){
            if(set.contains(i)){
                continue;
            }
            set.add(i);
            list.add(i);
            backtrack(nums,ans,list,set);
            list.remove(list.size()-1);
            set.remove(i);
        }
    }
}
