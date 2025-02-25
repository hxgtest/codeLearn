package hot100and150.链表;

/**
 * @author 12293
 * @description: TODO
 * @date 2025/2/25 10:24
 */
public class 合并K个升序链表二刷 {
    public ListNode mergeKLists(ListNode[] lists){
        return merge(lists,0,lists.length-1);
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
    public ListNode merge(ListNode[] lists,int start,int end){
        if(start==end){
            return lists[start];
        }
        if(start>end){
            return null;
        }
        int mid=(start+end)/2;
        return mergeTwoLists(merge(lists,start,mid),merge(lists,mid+1,end));
    }
}
