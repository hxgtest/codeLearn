package 代码随想录.栈与队列;

import java.util.*;

/*给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。

返回 滑动窗口中的最大值 。*/
public class 滑动窗口最大值 {
    public int[] maxSlidingWindow(int[] nums,int k){
        Deque<Integer> deque=new ArrayDeque<>();
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            //入
            while(!deque.isEmpty()&&nums[deque.getLast()]<=nums[i]){
                    deque.removeLast();
            }
            deque.addLast(nums[i]);
            if(i-deque.getFirst()+1>k){
                deque.removeFirst();
            }
            if(i>=k-1){
                ans.add(nums[deque.getFirst()]);
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
    public int[] maxSlidingWindow1(int[] nums,int k){
        int n=nums.length;
        PriorityQueue<int[]> pq=new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[0]!=o2[0]?o2[0]-o1[0]:o2[1]-o1[1];
            }
        });
        for(int i=0;i<k;i++){
            pq.offer(new int[]{nums[i],i});
        }
        int[] ans=new int[n-k+1];
        ans[0]=pq.peek()[0];
        for(int i=k;i<n;i++){
            pq.offer(new int[]{nums[i],i});
            while(pq.peek()[1]<=i-k){
                pq.poll();
            }
            ans[i-k+1]=pq.peek()[0];
        }
        return ans;
    }
}
