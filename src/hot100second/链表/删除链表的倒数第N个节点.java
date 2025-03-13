package hot100second.链表;

/**
 * @author hxg
 * @description: TODO
 * @date 2025/3/13 10:00
 */
public class 删除链表的倒数第N个节点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead=new ListNode(0,head);
        ListNode fast=head,slow=dummyHead;
        for(int i=0;i<n;i++){
            fast=fast.next;
        }
        while (fast!=null){
            slow=slow.next;
            fast=fast.next;
        }
        slow.next =slow.next.next;
        return dummyHead.next;
    }
}
