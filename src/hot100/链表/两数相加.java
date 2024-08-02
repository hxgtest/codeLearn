package hot100.链表;
//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
//
//请你将两个数相加，并以相同形式返回一个表示和的链表。
//
//你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
public class 两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=l1;
        int temp=0;
        while (l1!=null||l2!=null){
            l1.val=l1.val+l2.val+temp;
            temp=0;
            if(l1.val>=10){
                temp=1;
                l1.val-=10;
            }
            if (l1.next==null&&l2.next!=null){
                l1.next=new ListNode(0);
            }else if(l1.next!=null&&l2.next==null){
                l2.next=new ListNode(0);
            }
            if(temp==1&&l1.next==null&&l2.next==null){
                l1.next=new ListNode(1);
                break;
            }
            l1=l1.next;
            l2=l2.next;
        }
        return head;
    }
}
