package 代码随想录.二叉树;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 二叉树的层平均值 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        Deque<TreeNode> stack=new ArrayDeque<>();
        stack.addLast(root);
        ans.add((double)root.val);
        while(!stack.isEmpty()){
            int len=stack.size();
            double sum=0.00000;
            int num=0;
            for(int i=0;i<len;i++){
                TreeNode node=stack.removeFirst();

                if(node.left!=null){
                    stack.addLast(node.left);
                    sum+=node.left.val;
                    num++;
                }
                if(node.right!=null){
                    stack.addLast(node.right);
                    sum+=node.right.val;
                    num++;
                }
            }
            if(num!=0)
                ans.add(sum/stack.size());
        }
        return ans;
    }
}
