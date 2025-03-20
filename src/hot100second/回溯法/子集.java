package hot100second.回溯法;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 12293
 * @description: TODO
 * @date 2025/3/20 09:31
 */
public class 子集 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();


        ans.add(new ArrayList<>());
        for(int i=1;i<nums.length;i++){
            Set<Integer> set=new HashSet<>();
            List<Integer> list=new ArrayList<>();
            backtrack(nums,ans,list,set,i);
        }
        return ans;
    }
    public void backtrack(int[] nums,List<List<Integer>> ans,List<Integer> list,Set<Integer> set,int len){
        if(list.size()==len){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i:nums){
            if(set.contains(i)){
                continue;
            }
            if(!list.isEmpty() &&i<list.get(list.size()-1)){
                continue;
            }
            list.add(i);
            set.add(i);
            backtrack(nums,ans,list,set,len);
            list.remove(list.size()-1);
            set.remove(i);
        }
    }
}
