package 代码随想录.栈与队列;

import java.util.*;

/*
给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
*/
public class 前k个高频元素 {
    public int[] topKFrequent(int[] nums,int k){
        Map<Integer,Integer> map=new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1)-map.get(o2);
            }
        });
        for(Integer key:map.keySet()){
            if(pq.size()<k){
                pq.add(key);
            }else if(map.get(key)>map.get(pq.peek())){
                pq.remove();
                pq.add(key);
            }
        }
        int[] res=new int[k];
        int i=0;
        while(!pq.isEmpty()){
            res[i++]=pq.remove();
        }
        return res;
    }
    public int[] topKFrequent1(int[] nums,int k){
        Map<Integer,Integer> map=new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        List<Integer>[] freqList=new List[nums.length+1];
        for(int i=0;i<freqList.length;i++){
            freqList[i]=new ArrayList<>();
        }
        map.forEach((num,freq)->{
            freqList[freq].add(num);
        });
        int[] ans=new int[k];
        int i=0;
        for(int freq=freqList.length-1;freq>0;freq--){
            for(int num:freqList[freq]){
                ans[i++]=num;
                if(i==k){
                    return ans;
                }
            }
        }
        return ans;
    }
}
