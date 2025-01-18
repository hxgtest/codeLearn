package hot100and150.链表;
//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
public class 排序链表 {
    public ListNode sortList(ListNode head){
        return sortList(head,null);
    }
    public ListNode sortList(ListNode head,ListNode tail){
        if(head==null){
            return head;
        }
        if(head.next==tail){
            head.next=null;
            return head;
        }
        ListNode slow=head,fast=head;
        while(fast!=tail){
            slow=slow.next;
            fast=fast.next;
            if(fast!=tail){
                fast=fast.next;
            }
        }
        ListNode mid=slow;
        ListNode list1=sortList(head,mid);
        ListNode list2=sortList(mid,tail);
        ListNode sorted=merge(list1,list2);
        return sorted;
    }
    public ListNode merge(ListNode list1,ListNode list2){
        ListNode dummy=new ListNode(0);
        ListNode temp=dummy,temp1=list1,temp2=list2;
        while(temp1!=null&&temp2!=null){
            if(temp1.val<=temp2.val){
                temp.next=temp1;
                temp1=temp1.next;
            }else {
                temp.next=temp2;
                temp2=temp2.next;
            }
            temp=temp.next;
        }
        if(temp1!=null){
            temp.next=temp1;
        }else if(temp2!=null){
            temp.next=temp2;
        }
        return dummy.next;
    }
    public ListNode sortList2(ListNode head){
        if (head == null){
            return head;
        }
        int length=0;
        ListNode node=head;
        while (node!=null){
            length++;
            node=node.next;
        }
        ListNode dummyHead=new ListNode(0,head);
        for(int subLength=1;subLength<length;subLength<<=1){
            ListNode prev=dummyHead,curr=dummyHead.next;
            while (curr!=null){
                ListNode head1=curr;
                for(int i=1;i<subLength;i++){
                    curr=curr.next;
                }
                ListNode head2=curr.next;
                curr.next=null;
                curr=head2;
                for(int i=1;i<subLength;i++){
                    curr=curr.next;
                }
                ListNode next=null;
                if(curr!=null){
                    next=curr.next;
                    curr.next=null;
                }
                ListNode merged=merge(head1,head2);
                prev.next=merged;
                while(prev.next!=null){
                    prev=prev.next;
                }
                curr=next;
            }
        }
        return dummyHead.next;
    }
}
