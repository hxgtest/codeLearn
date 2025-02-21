package hot100and150.二叉树;

/**
 * @author hxg
 * @description: 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 *
 * 路径和 是路径中各节点值的总和。
 *
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * @date 2025/2/21 10:40
 */
public class 二叉树中的最大路径和二刷 {
    int maxSum = Integer.MIN_VALUE; // 维护全局最大值

    public int maxPathSum(TreeNode root) {
        calculateMaxContrib(root);
        return maxSum;
    }

    // 计算节点的最大贡献值（单边路径和）
    private int calculateMaxContrib(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // 递归计算左右子树贡献值（负数则舍弃）
        int leftContrib = Math.max(calculateMaxContrib(node.left), 0);
        int rightContrib = Math.max(calculateMaxContrib(node.right), 0);

        // 当前子树的最大路径和（可能包含根节点连接左右的情况）
        int pathSum = node.val + leftContrib + rightContrib;
        maxSum = Math.max(maxSum, pathSum); // 更新全局最大值

        // 返回该节点的最大单边贡献值（给父节点使用）
        return node.val + Math.max(leftContrib, rightContrib);
    }
}
