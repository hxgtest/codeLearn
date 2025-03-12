package hot100second.链表;

/**
 * @author hxg
 * @description: TODO
 * @date 2025/3/12 10:38
 */
public class 合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ans=new ListNode(0);
        ListNode dummyHead=ans;
        ListNode p1=list1,p2=list2;
        while (p1!=null||p2!=null){
            if(p1==null){
                ans.next=new ListNode(p2.val);
                p2=p2.next;
            }else if(p2==null){
                ans.next=new ListNode(p1.val);
                p1=p1.next;
            }else if(p1.val>p2.val){
                ans.next=new ListNode(p2.val);
                p2=p2.next;
            }else {
                ans.next=new ListNode(p1.val);
                p1=p1.next;
            }
            ans=ans.next;
        }
        return dummyHead.next;
    }
}
