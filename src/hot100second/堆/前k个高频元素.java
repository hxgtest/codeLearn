package hot100second.堆;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author 12293
 * @description: TODO
 * @date 2025/4/2 16:30
 */
public class 前k个高频元素 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        PriorityQueue<Integer> pq=new PriorityQueue<>(((o1, o2) -> map.get(o1)-map.get(o2)));
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        pq.addAll(map.keySet());
        int[] ans=new int[k];
        for(int i=0;i<k;i++){
            ans[i]=pq.remove();
        }
        return ans;
    }
}
