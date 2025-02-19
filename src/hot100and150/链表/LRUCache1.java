package hot100and150.链表;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 12293
 * @description: TODO
 * @date 2025/2/19 08:58
 */
public class LRUCache1 {

    public class DLinkNode{
        public DLinkNode(){}
        public DLinkNode(int _key,int _val){
            key=_key;
            val=_val;
        }
        int key;
        int val;
        DLinkNode prev;
        DLinkNode next;
    }
    Map<Integer,DLinkNode> nodeCache=new HashMap<>();
    int size;
    int capacity;
    DLinkNode head;
    DLinkNode tail;

    public LRUCache1(int capacity) {
        size=0;
        this.capacity=capacity;
        head=new DLinkNode();
        tail=new DLinkNode();
        head.next=tail;
        tail.prev=head;
    }

    public int get(int key) {
        if(nodeCache.containsKey(key)){
            DLinkNode node=nodeCache.get(key);
            node.prev.next=node.next;
            node.next.prev=node.prev;
            node.prev=head;
            node.next=head.next;
            head.next.prev=node;
            head.next=node;
            return node.val;
        }else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if(nodeCache.containsKey(key)){
            DLinkNode node=nodeCache.get(key);
            node.val=value;
            node.prev.next=node.next;
            node.next.prev=node.prev;
            node.prev=head;
            node.next=head.next;
            head.next.prev=node;
            head.next=node;
        }else {
            DLinkNode node=new DLinkNode(key,value);
            nodeCache.put(key,node);
            node.prev=head;
            node.next=head.next;
            head.next.prev=node;
            head.next=node;
            size++;
            if(size>capacity){
                int tailKey=tail.prev.key;
                tail.prev.prev.next=tail;
                tail.prev=tail.prev.prev;
                nodeCache.remove(tailKey);
                size--;
            }
        }
    }
}
