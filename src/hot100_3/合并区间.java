package hot100_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author hxg
 * @description: TODO
 * @date 2025/8/26 20:11
 */
public class 合并区间 {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans=new ArrayList<>();
        Arrays.sort(intervals,((o1, o2) -> o1[0]-o2[0]));
        int start=intervals[0][0],end=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=end){
                end=Math.max(end,intervals[i][1]);
            }else {
                ans.add(new int[]{start,end});
                start=intervals[i][0];
                end=intervals[i][1];
            }
        }
        return ans.toArray(new int[ans.size()][]);
        
    }
}
