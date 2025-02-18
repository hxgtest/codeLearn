package hot100and150.链表;

/**
 * @author hxg
 * @description: 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 *
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 * @date 2025/2/18 15:59
 */
public class 分隔链表 {
    public ListNode partition(ListNode head, int x) {
        ListNode smallEqual=new ListNode(0);
        ListNode big=new ListNode(0);
        ListNode curS=smallEqual,curB=big;
        while (head!=null){
            if(head.val<x){
                curS.next=head;
                curS=curS.next;
            }else {
                curB.next=head;
                curB=curB.next;
            }
            head=head.next;
        }
        curS.next=big.next;
        curB.next=null;
        return smallEqual.next;

    }
}
