package hot100and150.链表;

/**
 * @author hxg
 * @description: 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * @date 2025/2/18 15:51
 */
public class 旋转链表 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return null;
        }
        ListNode node=head;
        int len=0;
        while (node!=null){
            len++;
            node=node.next;
        }
        k%=len;
        ListNode dummy=new ListNode(0,head);
        ListNode first=dummy,second=dummy;
        for(int i=0;i<k;i++){
            first=first.next;
        }
        while (first.next!=null){
            first=first.next;
            second=second.next;
        }
        first.next=dummy.next;
        dummy.next=second.next;
        second.next=null;
        return dummy.next;

    }
}
