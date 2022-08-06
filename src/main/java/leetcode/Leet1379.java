package leetcode;

import java.util.Objects;

public class Leet1379 {
    TreeNode result;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (result != null) return result;
        if (!Objects.isNull(original)) {
            if (original == target) {
                result = cloned;
            } else {
                getTargetCopy(original.left, cloned.left, target);
                getTargetCopy(original.right, cloned.right, target);
            }
        };
        return result;
    }
}
