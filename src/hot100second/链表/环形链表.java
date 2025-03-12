package hot100second.链表;

/**
 * @author hxg
 * @description: TODO
 * @date 2025/3/12 10:32
 */
public class 环形链表 {
    public boolean hasCycle(ListNode head) {
        if(head==null){
            return false;
        }
        ListNode fast=head,slow=head;
        do {
            slow=slow.next;
            if(fast.next!=null){
                fast=fast.next.next;
            }
        }while (slow!=fast&&fast!=null&&fast.next!=null);
        if(slow==fast){
            return true;
        }else {
            return false;
        }
    }
}
