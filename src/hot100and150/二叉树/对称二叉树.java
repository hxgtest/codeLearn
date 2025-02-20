package hot100and150.二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hxg
 * @description: TODO
 * @date 2025/2/20 10:23
 */
public class 对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }

    public boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && check(left.left, right.right) && check(left.right, right.left);
    }

    public boolean check2(TreeNode left, TreeNode right) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(left);
        q.offer(right);
        while (!q.isEmpty()) {
            left = q.poll();
            right = q.poll();
            if (left == null && right == null) {
                continue;
            }
            if ((left == null || right == null) || (left.val != right.val)) {
                return false;
            }

            q.offer(left.left);
            q.offer(right.right);

            q.offer(left.right);
            q.offer(right.left);
        }
        return true;

    }
}
