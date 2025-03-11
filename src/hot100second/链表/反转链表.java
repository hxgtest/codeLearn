package hot100second.链表;

/**
 * @author 12293
 * @description: 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * @date 2025/3/11 09:53
 */
public class 反转链表 {
    public ListNode reverseList(ListNode head) {
        ListNode prev=null;
        ListNode curr=head;
        while (curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}
