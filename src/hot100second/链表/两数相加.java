package hot100second.链表;

/**
 * @author hxg
 * @description: TODO
 * @date 2025/3/12 10:58
 */
public class 两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1=l1,p2=l2;
        int extra=0;
        while (p1!=null||p2!=null){
            p1.val+=p2.val+extra;
            extra=0;
            if(p1.val>=10){
                p1.val-=10;
                extra=1;
            }
            if(p1.next==null&&p2.next!=null){
                p1.next=new ListNode(0);
            }else if(p2.next==null&&p1.next!=null){
                p2.next=new ListNode(0);
            }
            if(extra==1&&p1.next==null){
                p1.next=new ListNode(1);
                break;
            }
            p1=p1.next;
            p2=p2.next;
        }
        return l1;
    }
}
