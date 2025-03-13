package hot100second.链表;

/**
 * @author hxg
 * @description: TODO
 * @date 2025/3/13 10:07
 */
public class 两两交换链表中的节点 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead=new ListNode(0,head);
        ListNode curr = head,prev=dummyHead;
        while (curr!=null&&curr.next!=null){
            ListNode next=curr.next.next;
            prev.next=curr.next;
            curr.next.next=curr;
            curr.next=next;
            prev=curr;
            curr=next;
        }
        return dummyHead.next;
    }
}
