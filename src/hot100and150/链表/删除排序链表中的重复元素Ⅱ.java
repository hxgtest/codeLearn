package hot100and150.链表;

/**
 * @author hxg
 * @description: 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 * @date 2025/2/18 15:37
 */
public class 删除排序链表中的重复元素Ⅱ {
    public ListNode deleteDuplicates(ListNode head) {

        if(head==null){
            return null;
        }
        ListNode dummy=new ListNode(0,head);
        ListNode cur=dummy;
        while(cur.next!=null&&cur.next.next!=null){
            if(cur.next.val==cur.next.next.val){
                int x=cur.next.val;
                while(cur.next!=null&&cur.next.val==x){
                    cur=cur.next;
                }
            }else {
                cur=cur.next;
            }
        }
        return dummy.next;
    }
}
