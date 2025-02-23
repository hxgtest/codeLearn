package hot100and150.回溯法;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hxg
 * @description: 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * <p>
 * 你可以按 任何顺序 返回答案。
 * @date 2025/2/23 12:01
 */
public class 组合 {
    List<Integer> list=new ArrayList<>();
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtrack(n,k,1);
        return ans;
    }

    public void backtrack( int n, int k, int index) {
        if(list.size()+n-index+1<k){
            return;
        }
        if (list.size() == k) {
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(index);
        backtrack(n,k,index+1);
        list.remove(list.size()-1);
        backtrack(n,k,index+1);

    }
}
