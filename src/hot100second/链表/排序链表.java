package hot100second.链表;

/**
 * @author hxg
 * @description: 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * @date 2025/3/13 10:31
 */
public class 排序链表 {
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }

        ListNode head2=middleNode(head);
        head=sortList(head);
        head2=sortList(head2);
        return mergeTwoList(head,head2);
    }
    private ListNode middleNode(ListNode head){
        ListNode pre=head;
        ListNode slow=head;
        ListNode fast=head;
        while (fast!=null&&fast.next!=null){
            pre=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        pre.next=null;
        return slow;
    }
    private ListNode mergeTwoList(ListNode list1,ListNode list2){
        ListNode dummy=new ListNode();
        ListNode cur=dummy;
        while (list1!=null&&list2!=null){
            if(list1.val<list2.val){
                cur.next=list1;
                list1=list1.next;
            }else {
                cur.next=list2;
                list2=list2.next;
            }
            cur=cur.next;
        }
        cur.next=list1!=null?list1:list2;
        return dummy.next;
    }
}
