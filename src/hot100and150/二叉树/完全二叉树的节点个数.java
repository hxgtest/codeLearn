package hot100and150.二叉树;

/**
 * @author hxg
 * @description: 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 * <p>
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层（从第 0 层开始），则该层包含 1~ 2h 个节点。
 * @date 2025/2/22 16:03
 */
public class 完全二叉树的节点个数 {

    public int countLevel(TreeNode root) {
        int level = 0;
        while (root != null) {
            level++;
            root = root.left;
        }
        return level;
    }
    public int countNodes1(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=countLevel(root.left);
        int right=countLevel(root.right);
        if(left==right){
            return countNodes1(root.right)+(1<<left);
        }else {
            return countNodes1(root.left)+(1<<right);
        }
    }
    public int countNodes2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int level = 0;
        TreeNode node = root;
        while (node.left != null) {
            level++;
            node = node.left;
        }
        int low = 1 << level, high = (1 << (level + 1)) - 1;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (exists1(root, level, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public boolean exists1(TreeNode root, int level, int k) {
        int bits = 1 << (level - 1);
        TreeNode node = root;
        while (node != null && bits > 0) {
            if ((bits & k) == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
            bits >>= 1;
        }
        return node != null;
    }
}
