package hot100and150.二叉树;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author hxg
 * @description: 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 * @date 2025/2/21 09:14
 */
public class 二叉树转换为链表二刷 {
    public void flatten(TreeNode root) {
        List<TreeNode> list=new LinkedList<>();
        preorderTraversal(root,list);
        int size=list.size();
        for(int i=1;i<size;i++){
            TreeNode prev=list.get(i-1),curr=list.get(i);
            prev.right=curr;
            prev.left=null;
        }
    }
    public void preorderTraversal(TreeNode root, List<TreeNode> list){
        if(root!=null){
            list.add(root);
            preorderTraversal(root.left,list);
            preorderTraversal(root.right,list);
        }
    }
    public void flatten1(TreeNode root) {
        if(root==null){
            return;
        }
        Deque<TreeNode> stack=new LinkedList<>();
        stack.push(root);
        TreeNode prev=null;
        while(!stack.isEmpty()){
            TreeNode curr=stack.pop();
            if(prev!=null){
                prev.left=null;
                prev.right=curr;
            }
            TreeNode left=curr.left,right=curr.right;
            if(right!=null){
                stack.push(right);
            }
            if(left!=null){
                stack.push(left);
            }
            prev=curr;
        }
    }
    public void flatten2(TreeNode root){
        TreeNode curr=root;
        while (curr!=null){
            if(curr.left!=null){
                TreeNode next=curr.left;
                TreeNode predecessor=next;
                while(predecessor.right!=null){
                    predecessor=predecessor.right;
                }
                predecessor.right=curr.right;
                curr.left=null;
                curr.right=next;
            }
            curr=curr.right;
        }
    }
}
