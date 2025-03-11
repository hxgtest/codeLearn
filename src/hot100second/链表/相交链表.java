package hot100second.链表;

/**
 * @author 12293
 * @description: TODO
 * @date 2025/3/11 09:44
 */
public class 相交链表 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1=0,len2=0;
        ListNode node=headA;
        while (node!=null){
            len1++;
            node=node.next;
        }
        node=headB;
        while (node!=null){
            len2++;
            node=node.next;
        }
        node=headA;
        ListNode node1=headB;
        while (len1>len2){
            node=node.next;
            len1--;
        }
        while(len1<len2){
            node1=node1.next;
            len2--;
        }
        while (node!=null&&node1!=null){
            if(node==node1){
                return node;
            }
            node=node.next;
            node1=node1.next;
        }
        return null;
    }
}
