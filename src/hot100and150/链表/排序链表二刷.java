package hot100and150.链表;

/**
 * @author 12293
 * @description: 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * @date 2025/2/25 09:31
 */
public class 排序链表二刷 {
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }

        ListNode head2=middleNode(head);
        head=sortList(head);
        head2=sortList(head2);
        return mergeTwoLists(head,head2);
    }

    public ListNode middleNode(ListNode head){
        ListNode pre=head;
        ListNode slow=head;
        ListNode fast=head;
        while (fast!=null&&fast.next!=null){
            pre=slow;
            fast=fast.next.next;
            slow=slow.next;
        }
        pre.next=null;
        return slow;
    }

    public ListNode mergeTwoLists(ListNode list1,ListNode list2){
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
    private ListNode[] mergeTwoLists1(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(); // 用哨兵节点简化代码逻辑
        ListNode cur = dummy; // cur 指向新链表的末尾
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1; // 把 list1 加到新链表中
                list1 = list1.next;
            } else { // 注：相等的情况加哪个节点都是可以的
                cur.next = list2; // 把 list2 加到新链表中
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = list1 != null ? list1 : list2; // 拼接剩余链表
        while (cur.next != null) {
            cur = cur.next;
        }
        // 循环结束后，cur 是合并后的链表的尾节点
        return new ListNode[]{dummy.next, cur};
    }

    public ListNode sortList1(ListNode head){
        int length=getListLength(head);
        ListNode dummy=new ListNode(0,head);
        for(int step=1;step<length;step*=2){
            ListNode newListTail=dummy;
            ListNode cur=dummy.next;
            while(cur!=null){
                ListNode head1=cur;
                ListNode head2=splitList(head1,step);
                cur=splitList(head2,step);
                ListNode[] merged=mergeTwoLists1(head1,head2);
                newListTail.next=merged[0];
                newListTail=merged[1];
            }
        }
        return dummy.next;
    }

    //获取链表长度
    public int getListLength(ListNode head){
        int length=0;
        while (head!=null){
            length++;
            head=head.next;
        }
        return length;
    }

    //分割链表
    //如果链表长度<=size,不做任何操作，返回空节点，如果>=size，把连标点前size个节点分割出来，并返回剩余链表的头结点
    public ListNode splitList(ListNode head,int size){
        ListNode cur=head;
        for (int i=0;i<size-1&&cur!=null;i++){
            cur=cur.next;
        }

        if(cur==null||cur.next==null){
            return null;
        }
        ListNode nextHead=cur.next;
        cur.next=null;
        return nextHead;
    }
}
