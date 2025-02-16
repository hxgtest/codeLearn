package hot100and150.区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author hxg
 * @description: 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * @date 2025/2/16 09:25
 */
public class 合并区间 {
    public int[][] merge(int[][] intervals) {

        if(intervals.length==0){
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        List<int[]> merged=new ArrayList<>();
        int start=intervals[0][0],end=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=end){
                end = Math.max(end, intervals[i][1]);
            }else {
                merged.add(new int[]{start,end});
                start=intervals[i][0];
                end=intervals[i][1];
            }
        }
        merged.add(new int[]{start,end});
        return merged.toArray(new int[merged.size()][]);
    }
}
