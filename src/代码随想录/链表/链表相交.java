package 代码随想录.链表;
/*给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null*/
public class 链表相交 {
    public ListNode getIntersectionNode(ListNode headA,ListNode headB){
        ListNode node=headA;
        int lenA=0,lenB=0;
        while(node!=null){
            node=node.next;
            lenA++;
        }
        node=headB;
        while(node!=null){
            node=node.next;
            lenB++;
        }
        if(lenA<lenB){
            node=headA;
            headA=headB;
            headB=node;
        }
        for(int i=0;i<Math.abs(lenA-lenB);i++){
            headA=headA.next;
        }
        while(headA!=headB){
            headA=headA.next;
            headB=headB.next;

        }
        return headA;

    }
}
