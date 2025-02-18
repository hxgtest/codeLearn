package hot100and150.链表;

/**
 * @author hxg
 * @description: 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * @date 2025/2/17 15:20
 */
public class 反转链表Ⅱ {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1); // 哑节点简化头节点处理
        dummy.next = head;
        ListNode preLeft = dummy;

        // 定位到left的前一个节点
        for (int i = 1; i < left; i++) {
            preLeft = preLeft.next;
        }
        ListNode curr = preLeft.next;
        ListNode prev = null;
        ListNode next;
        // 反转区间[left, right]
        for (int i = 0; i < right - left + 1; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // 连接反转后的头尾
        preLeft.next.next = curr; // 原left节点指向剩余链表
        preLeft.next = prev;      // 前驱节点指向新头

        return dummy.next; // 哑节点的next始终是正确头节点
    }
    public ListNode reverseBetween1(ListNode head,int left,int right){
        ListNode dummyNode=new ListNode(-1);
        dummyNode.next=head;
        ListNode pre=dummyNode;
        for(int i=0;i<left;i++){
            pre=pre.next;
        }
        ListNode cur=pre.next;
        ListNode next;
        for(int i=0;i<right-left;i++){
            next=cur.next;
            cur.next=next.next;
            next.next=pre.next;
            pre.next=next;
        }
        return dummyNode.next;
    }
}
