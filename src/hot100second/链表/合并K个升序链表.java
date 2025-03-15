package hot100second.链表;

/**
 * @author hxg
 * @description: 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * @date 2025/3/15 15:13
 */
public class 合并K个升序链表 {
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists,0,lists.length-1);
    }
    public ListNode mergeTwoList(ListNode list1,ListNode list2){
        ListNode dummy=new ListNode();
        ListNode curr=dummy;
        while (list1!=null&&list2!=null){
            if(list1.val<list2.val){
                curr.next=list1;
                list1=list1.next;
            }else {
                curr.next=list2;
                list2=list2.next;
            }
            curr=curr.next;
        }
        curr.next=list1==null?list2:list1;
        return dummy.next;
    }
    public ListNode merge(ListNode[] lists,int start,int end){
        if(start==end){
            return lists[start];
        }
        if(start>end){
            return null;
        }
        int mid=(start+end)/2;
        return mergeTwoList(merge(lists,start,mid),merge(lists,mid+1,end));
    }
}
