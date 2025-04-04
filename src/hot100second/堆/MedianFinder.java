package hot100second.堆;

import java.util.PriorityQueue;

/**
 * @author 12293
 * @description: TODO
 * @date 2025/4/4 20:21
 */
public class MedianFinder {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;
    int size;
    public MedianFinder() {
        left=new PriorityQueue<>((o1, o2) -> o2-o1);
        right=new PriorityQueue<>((o1, o2) -> o1-o2);
        size=0;
    }

    public void addNum(int num) {
        if(left.isEmpty()||num<=left.peek()){
            left.offer(num);
            if(right.size()+1<left.size()){
                right.offer(left.poll());
            }
        }else {
            right.offer(num);
            if(right.size()>left.size()){
                left.offer(right.poll());
            }
        }
        size++;

    }

    public double findMedian() {
        if(size%2==1){
            return left.peek();
        }else {
            return (left.peek()+right.peek())/2.0;
        }
    }
}
