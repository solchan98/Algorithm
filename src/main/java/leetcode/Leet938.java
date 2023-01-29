package leetcode;

public class Leet938 {
    public int rangeSumBST(TreeNode root, int low, int high) {
        return dfs(root, low, high);
    }

    public int dfs(TreeNode node, int low, int high) {
        int sum = inRange(node.val, low, high) ? node.val : 0;
        if (node.left != null) {
            sum += dfs(node.left, low, high);
        }

        if (node.right != null) {
            sum += dfs(node.right, low, high);
        }
        return sum;
    }

    private boolean inRange(int value, int low, int high) {
        return value >= low && value <= high;
    }
}
