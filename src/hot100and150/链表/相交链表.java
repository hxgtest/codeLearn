package hot100and150.链表;

public class 相交链表 {
    public ListNode getIntersectionNode(ListNode headA,ListNode headB){
        ListNode nodeA=headA,nodeB=headB;
        int lenA=0,lenB=0;
        while(nodeA!=null){
            lenA++;
            nodeA=nodeA.next;
        }
        while (nodeB!=null){
            lenB++;
            nodeB=nodeB.next;
        }
        nodeA=headA;
        nodeB=headB;
        if(lenA>lenB){
            for(int i=0;i<lenA-lenB;i++){
                nodeA=nodeA.next;
            }
        }else {
            for(int i=0;i<lenB-lenA;i++){
                nodeB=nodeB.next;
            }
        }
        while(nodeA!=null){
            if(nodeA.equals(nodeB)){
                return nodeA;
            }else {
                nodeA=nodeA.next;
                nodeB=nodeB.next;
            }
        }
        return null;

    }
}
