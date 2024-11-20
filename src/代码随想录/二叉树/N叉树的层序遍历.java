package 代码随想录.二叉树;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class N叉树的层序遍历 {
    public List<List<Integer>> levelOrder(Node root){
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        Deque<Node> stack=new ArrayDeque<>();
        stack.addLast(root);
        while(!stack.isEmpty()){
            int len=stack.size();
            List<Integer> level=new ArrayList<>();
            for(int i=0;i<len;i++){
                Node node=stack.removeFirst();
                for(Node child:node.children){
                    stack.addLast(child);
                }
                level.add(node.val);
            }
            ans.add(level);
        }
        return ans;
    }
}
