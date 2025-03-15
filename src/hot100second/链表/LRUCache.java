package hot100second.链表;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hxg
 * @description: TODO
 * @date 2025/3/15 16:32
 */
public class LRUCache {
    class DLinkedNode{
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode(){}
        public DLinkedNode(int _key,int _value){
            key=_key;
            value=_value;
        }
    }
    private Map<Integer,DLinkedNode> cache=new HashMap<>();
    private int size;
    private int capacity;
    DLinkedNode head,tail;
    public LRUCache(int capacity) {
        this.size=0;
        this.capacity=capacity;
        head=new DLinkedNode();
        tail=new DLinkedNode();
        head.next=tail;
        tail.prev=head;
    }

    public int get(int key) {
        DLinkedNode node=cache.get(key);
        if(node==null){
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node=cache.get(key);
        if(node==null){
            DLinkedNode newNode=new DLinkedNode(key,value);
            cache.put(key,newNode);
            size++;
            addToHead(newNode);
            if(size>capacity){
                DLinkedNode tail=removeTail();
                cache.remove(tail.key);
                size--;
            }
        }else {
            node.value=value;
            moveToHead(node);
        }
    }
    public void addToHead(DLinkedNode node){
        node.prev=head;
        node.next=head.next;
        head.next.prev=node;
        head.next=node;
    }
    public void removeNode(DLinkedNode node){
        node.next.prev=node.prev;
        node.prev.next=node.next;
    }
    public void moveToHead(DLinkedNode node){
        removeNode(node);
        addToHead(node);
    }
    public DLinkedNode removeTail(){
        DLinkedNode node=tail.prev;
        removeNode(node);
        return node;
    }
}
