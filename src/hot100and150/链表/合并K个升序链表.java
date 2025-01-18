package hot100and150.链表;
//给你一个链表数组，每个链表都已经按升序排列。

//请你将所有链表合并到一个升序链表中，返回合并后的链表。
public class 合并K个升序链表 {
    public ListNode mergeKList(ListNode[] lists){
        return merge(lists,0,lists.length-1);
    }
    public ListNode mergeTwoLists(ListNode list1,ListNode list2){
        //首先确认头节点
        ListNode head=new ListNode(0),node=head;

        ListNode node1=list1;
        ListNode node2=list2;
        while(node1!=null||node2!=null){
            //将list2插入list1中，遍历每个元素
            //先考虑特殊情况list1为空或list2为空
            if(node2==null){
                //直接退出循环
                node.next=node1;
                break;
            }else if(node1==null){
                node.next=node2;
                break;
            }
            if(node1.val<node2.val){
                node.next=node1;
                node1=node1.next;
            }else {
                node.next=node2;
                node2=node2.next;
            }
            node=node.next;
        }
        return head.next;
    }
    public ListNode merge(ListNode[] lists,int l,int r){
        if(l==r){
            return lists[l];
        }
        if(l>r){
            return null;
        }
        int mid=(l+r)>>1;
        return mergeTwoLists(merge(lists,l,mid),merge(lists,mid+1,r));
    }
}
