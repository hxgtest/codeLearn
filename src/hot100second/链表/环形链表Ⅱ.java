package hot100second.链表;

/**
 * @author hxg
 * @description: TODO
 * @date 2025/3/12 10:36
 */
public class 环形链表Ⅱ {
    public ListNode detectCycle(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode fast=head,slow=head;
        do {
            slow=slow.next;
            if(fast.next!=null){
                fast=fast.next.next;
            }
        }while (slow!=fast&&fast!=null&&fast.next!=null);
        if(slow==fast){
            slow=head;
            while (slow!=fast){
                slow=slow.next;
                fast=fast.next;
            }
            return slow;
        }else {
            return null;
        }
    }
}
