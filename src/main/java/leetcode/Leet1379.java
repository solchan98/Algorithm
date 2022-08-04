package leetcode;

public class Leet1379 {
    TreeNode result;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (result != null) return result;
        if (original != null) {
            getTargetCopy(original.left, cloned.left, target);
            if (original == target) {
                result = cloned;
            }
            getTargetCopy(original.right, cloned.right, target);
        }
        return result;
    }
}
