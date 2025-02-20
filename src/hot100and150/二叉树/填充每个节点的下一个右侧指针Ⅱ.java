package hot100and150.二叉树;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author hxg
 * @description: 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL 。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL 。
 * @date 2025/2/20 10:53
 */
public class 填充每个节点的下一个右侧指针Ⅱ {
    public Node connect(Node root) {
        if(root==null){
            return root;
        }
        Queue<Node> queue=new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int n=queue.size();
            Node last=null;
            for(int i=0;i<n;i++){
                Node f=queue.poll();
                if(f.left!=null){
                    queue.offer(f.left);
                }
                if(f.right!=null){
                    queue.offer(f.right);
                }
                if(i!=0){
                    last.next=f;
                }
                last=f;
            }
        }
        return root;
    }
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}
