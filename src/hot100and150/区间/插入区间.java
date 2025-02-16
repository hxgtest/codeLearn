package hot100and150.区间;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hxg
 * @description: 给你一个 无重叠的 ，按照区间起始端点排序的区间列表 intervals，其中 intervals[i] = [starti, endi] 表示第 i 个区间的开始和结束，并且 intervals 按照 starti 升序排列。同样给定一个区间 newInterval = [start, end] 表示另一个区间的开始和结束。
 *
 * 在 intervals 中插入区间 newInterval，使得 intervals 依然按照 starti 升序排列，且区间之间不重叠（如果有必要的话，可以合并区间）。
 *
 * 返回插入之后的 intervals。
 *
 * 注意 你不需要原地修改 intervals。你可以创建一个新数组然后返回它。
 * @date 2025/2/16 10:03
 */
public class 插入区间 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n=intervals.length;
        List<int[]> merged=new ArrayList<>();
        int left=newInterval[0],right=newInterval[1];
        boolean placed=false;
        for(int[] interval:intervals){
            if(interval[0]>right){
                if(!placed){
                    merged.add(new int[]{left,right});
                    placed=true;
                }
                merged.add(interval);
            }else if(interval[1]<left){
                merged.add(interval);
            }else {
                left=Math.min(left,interval[0]);
                right=Math.max(right,interval[1]);
            }
        }
        if(!placed){
            merged.add(new int[]{left,right});
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
