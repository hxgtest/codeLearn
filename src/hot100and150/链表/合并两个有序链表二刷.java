package hot100and150.链表;

/**
 * @author 12293
 * @description: 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * @date 2025/2/17 10:11
 */
public class 合并两个有序链表二刷 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ans=new ListNode(0);
        ListNode l1=list1,l2=list2;
        while(l1!=null||l2!=null){
            if(l1==null){
                ans.next=new ListNode(l2.val);
                l2=l2.next;
            }else if(l2==null){
                ans.next=new ListNode(l1.val);
                l1=l1.next;
            }else if(l1.val>l2.val){
                ans.next=new ListNode(l2.val);
                l2=l2.next;
            }else {
                ans.next=new ListNode(l1.val);
                l1=l1.next;
            }
        }
        return ans.next;
    }
}
