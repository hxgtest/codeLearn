package hot100and150.链表;

public class 反转链表 {
    public ListNode reverseList1(ListNode head) {
       ListNode curr=head;
       ListNode prev=null;
       while(curr!=null){
           ListNode next=curr.next;
           curr.next=prev;
           prev=curr;
           curr=next;
       }
       return prev;
    }
    public ListNode reverseList(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode newHead=reverseList(head.next);
        head.next.next=head;
        //这一步不太好理解
        head.next=null;
        return newHead;
    }
}
