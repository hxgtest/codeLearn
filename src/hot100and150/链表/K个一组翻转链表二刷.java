package hot100and150.链表;

/**
 * @author hxg
 * @description: 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * @date 2025/2/18 15:04
 */
public class K个一组翻转链表二刷 {
    public ListNode reverseKGroup(ListNode head, int k) {
        int len=0;
        ListNode node=head;
        while (node!=null){
            len++;
            node=node.next;
        }
        int round=len/k;
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode preLeft=dummy;
        for(int i=0;i<round;i++){
            ListNode curr = preLeft.next;
            ListNode prev = null;
            ListNode next;
            // 反转区间[left, right]
            for (int j = 0; j < k; j++) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            // 连接反转后的头尾
            preLeft.next.next = curr; // 原left节点指向剩余链表
            next=preLeft.next;
            preLeft.next = prev;      // 前驱节点指向新头
            preLeft=next;
        }
        return dummy.next;
    }
}
