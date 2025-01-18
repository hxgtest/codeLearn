package hot100and150.链表;

//给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
//
//k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
//
//你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
public class K个一组反转链表 {
    public ListNode reverseKGroup(ListNode head, int k) {
        //只能说我是天才
        ListNode dummy=new ListNode(0);
        ListNode node=dummy;
        node.next=head;
        int len=0;
        while(node.next!=null){
            len++;
            node=node.next;
        }
        node=dummy;
        int num=len/k;
        for(int i=1;i<=num;i++){
            node.next=reverseList(node.next,k);
            for(int j=1;j<=k;j++){
                node=node.next;
            }
        }
        return dummy.next;
    }
    public ListNode reverseList(ListNode head, int k){
        //这样的写法是将头节点后k个节点翻转，但是没有跟后面的节点进行连接，而且跟前面的节点也没有进行连接
        //所以在开始时应该考虑初始化一个哨兵节点
        ListNode curr=head;
        ListNode prev=null;
        ListNode node=head;
        for(int i=1;i<=k;i++){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        node.next=curr;

        return prev;

    }
}
