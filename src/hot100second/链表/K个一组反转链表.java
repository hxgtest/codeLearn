package hot100second.链表;

/**
 * @author hxg
 * @description: TODO
 * @date 2025/3/13 10:15
 */
public class K个一组反转链表 {
    public ListNode reverseKGroup(ListNode head, int k) {
        int len=0;
        ListNode node=head;
        while (node!=null){
            len++;
            node=node.next;
        }
        int round=len/k;
        ListNode dummyHead=new ListNode(0,head);
        ListNode preLeft=dummyHead;
        for(int i=0;i<round;i++){
            ListNode curr=preLeft.next;
            ListNode prev=null;
            ListNode next;
            for(int j=0;j<k;j++){
                next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
            }
            preLeft.next.next=curr;
            next=preLeft.next;
            preLeft.next=prev;
            preLeft=next;
        }
        return dummyHead.next;
    }
}
