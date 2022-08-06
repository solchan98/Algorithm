package leetcode;

import java.util.Objects;

public class Leet1315 {

    public int sumEvenGrandparent(TreeNode root) {
        return dfs(root, null, null);
    }

    private int dfs(TreeNode node, TreeNode parent, TreeNode grandparent) {
        int sum = 0;
        if (Objects.isNull(node)) return sum;
        if (!Objects.isNull(grandparent) && grandparent.val % 2 == 0) {
            sum += node.val;
        }

        sum += dfs(node.left, node, parent);
        sum += dfs(node.right, node, parent);
        return sum;
    }
}