package leetcode;

public class Leet1302 {

    int maxLevel = 0;
    int sum = 0;

    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode node, int level) {
        if (node == null) return;

        if (level > maxLevel) {
            maxLevel = level;
            sum = node.val;
        } else if (level == maxLevel) {
            sum += node.val;
        }

        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }
}
