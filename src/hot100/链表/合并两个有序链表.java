package hot100.链表;
//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
public class 合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode list1,ListNode list2){
        //首先确认头节点
        ListNode head=new ListNode(0),node=head;

        ListNode node1=list1;
        ListNode node2=list2;
        while(node1!=null||node2!=null){
            //将list2插入list1中，遍历每个元素
            //先考虑特殊情况list1为空或list2为空
            if(node2==null){
                //直接退出循环
                node.next=node1;
                break;
            }else if(node1==null){
                node.next=node2;
                break;
            }
            if(node1.val<node2.val){
                node.next=node1;
                node1=node1.next;
            }else {
                node.next=node2;
                node2=node2.next;
            }
            node=node.next;
        }
        return head;
    }
}
