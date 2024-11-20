package 代码随想录.二叉树;

import java.util.ArrayDeque;
import java.util.Deque;

public class 填充每个节点的下一个右侧节点指针 {
//方法二：利用next在每一层构建链表，就无需队列
    public Node connect(Node root){
        if(root==null){
            return root;
        }

        Deque<Node> stack=new ArrayDeque<>();
        stack.addLast(root);
        while(!stack.isEmpty()){
            int len=stack.size();
            Node prev=null;
            for(int i=0;i<len;i++){
                Node cur=stack.removeFirst();
                if(prev!=null){
                    prev.next=cur;
                }
                prev=cur;
                if(cur.left!=null){
                    stack.addLast(cur.left);
                }
                if(cur.right!=null){
                    stack.addLast(cur.right);
                }
            }
            prev.next=null;
        }
        return root;
    }

}
