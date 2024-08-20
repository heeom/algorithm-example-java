package ch14;

public class Solution58 {
    int prev = Integer.MIN_VALUE + 100000;
    int minValue = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        if (root.left != null) {
            minDiffInBST(root.left);
        }
        minValue = Math.min(minValue, root.val - prev);
        prev = root.val;

        if (root.right != null) {
            minDiffInBST(root.right);
        }
        return minValue;
    }
}
