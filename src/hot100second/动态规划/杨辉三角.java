package hot100second.动态规划;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 12293
 * @description: TODO
 * @date 2025/4/9 09:03
 */
public class 杨辉三角 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Integer> list=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0||j==i){
                    list.add(1);
                }else {
                    list.add(ans.get(i-1).get(j-1)+ans.get(i-1).get(j));
                }
            }
            ans.add(list);
        }
        return ans;
    }
}
