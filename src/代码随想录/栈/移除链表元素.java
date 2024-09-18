package 代码随想录.栈;


/*
给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
*/
public class 移除链表元素 {
    public ListNode removeElements(ListNode head,int val){
        if(head==null){
            return head;
        }
        head.next=removeElements(head.next,val);
        return head.val==val?head.next:head;
    }
    public ListNode removeElements1(ListNode head,int val){
        ListNode dummyHead=new ListNode(0);
        dummyHead.next=head;
        ListNode temp=dummyHead;
        while (temp.next!=null){
            if(temp.val==val){
                temp.next=temp.next.next;
            }else {
                temp=temp.next;
            }
        }
        return dummyHead.next;
    }
}
