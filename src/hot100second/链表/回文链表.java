package hot100second.链表;

/**
 * @author 12293
 * @description: TODO
 * @date 2025/3/11 10:21
 */
public class 回文链表 {
    public boolean isPalindrome(ListNode head) {
        if(head==null){
            return true;
        }

        ListNode firstHalfEnd=endOfFirstHalf(head);
        ListNode secondHalfStart=reverseList(firstHalfEnd.next);
        ListNode p1=head;
        ListNode p2=secondHalfStart;
        boolean result=true;
        while (result&&p2!=null){
            if(p1.val!=p2.val){
                result=false;
            }
            p1=p1.next;
            p2=p2.next;
        }
        firstHalfEnd.next=reverseList(secondHalfStart);
        return result;
    }
    public ListNode reverseList(ListNode head) {
        ListNode prev=null;
        ListNode curr=head;
        while (curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    public ListNode endOfFirstHalf(ListNode head){
        ListNode fast=head;
        ListNode slow=head;
        while(fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
}
