package 代码随想录.栈;
/*给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。*/
public class 删除链表的倒数第N个节点 {
    public ListNode removeNthFromEnd(ListNode head,int n){
        ListNode dummyHead=new ListNode(0);
        dummyHead.next=head;
        ListNode slow=dummyHead,fast=dummyHead;
        for(int i=0;i<n;i++){
            fast=fast.next;
        }
        ListNode prev=dummyHead;
        while (fast != null) {
            prev=slow;
            slow=slow.next;
            fast=fast.next;
        }
        prev.next=slow.next;
        return dummyHead.next;
    }
}
