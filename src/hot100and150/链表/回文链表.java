package hot100and150.链表;

//给你一个单链表的头节点 head ，请你判断该链表是否为
//        回文链表
//。如果是，返回 true ；否则，返回 false 。
public class 回文链表 {
    public boolean isPalindrome(ListNode head){
        //空间复杂度为O(n)的做法
        ListNode node=head;
        int len=0;
        while(node!=null){
            len++;
            node=node.next;
        }
        int[] rec=new int[len];
        node=head;
        int i=0;
        while (node!=null){
            rec[i++]=node.val;
            node=node.next;
        }
        int left=0,right=len-1;
        while (left<right){
            if(rec[left]==rec[right]){
                left++;
                right--;
                continue;
            }else {
                return false;
            }
        }
        return true;
    }
    public boolean isPalindrome2(ListNode head){
        //如何将空间复杂度降到O(1)?
        //首先还是先测量长度，这里我们换一种方法，使用快慢指针，快的一次走两格，慢的一次走一格，快的如果走到了null位置说明总数是偶数个节点，反之是奇数个节点。
        ListNode slow=head,fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        //接下来将slow到fast之间的链表进行翻转
        ListNode curr=slow.next;
        ListNode prev=slow;
        while (curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        ListNode left=head,right=prev;
        while (left!=slow&&right!=null){
            if(left.val!=right.val){
                return false;
            }
            left=left.next;
            right=right.next;
        }
        return true;
    }
}
