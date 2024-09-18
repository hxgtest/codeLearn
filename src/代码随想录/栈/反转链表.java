package 代码随想录.栈;
/*
给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
*/

public class 反转链表 {
    public ListNode reverseList(ListNode head){
        ListNode curr=head;
        ListNode prev=null;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=prev;
            curr=next;
        }
        return prev;
    }
}
