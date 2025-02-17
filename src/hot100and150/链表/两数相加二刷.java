package hot100and150.链表;

/**
 * @author 12293
 * @description: 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * @date 2025/2/17 09:58
 */
public class 两数相加二刷 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ptr1=l1,ptr2=l2,ptr3;
        int big=0;
        while(ptr1!=null||ptr2!=null){
            ptr1.val=ptr1.val+ptr2.val+big;
            big=0;
            if(ptr1.val>=10){
                ptr1.val-=10;
                big++;
            }
            if(ptr1.next==null&&ptr2.next!=null){
                ptr1.next=new ListNode(0);
            }else if(ptr2.next==null&&ptr1.next!=null){
                ptr2.next=new ListNode(0);
            }
            if(big == 1 && ptr1.next == null){
                ptr1.next=new ListNode(1);
                break;
            }
            ptr1=ptr1.next;
            ptr2=ptr2.next;
        }
        return l1;
    }
}
