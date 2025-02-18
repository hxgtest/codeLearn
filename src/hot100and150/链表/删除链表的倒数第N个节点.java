package hot100and150.链表;

/**
 * @author hxg
 * @description: TODO
 * @date 2025/2/18 15:26
 */
public class 删除链表的倒数第N个节点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy=new ListNode(0,head);
        ListNode fast=head,slow=dummy;
        slow.next=head;
        for(int i=1;i<n;i++){
            fast=fast.next;
        }
        while (fast!=null){
            slow=slow.next;
            fast=fast.next;
        }
        slow.next=slow.next.next;
        return dummy.next;
    }
}
