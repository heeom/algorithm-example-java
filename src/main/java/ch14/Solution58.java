package ch14;

import java.util.ArrayDeque;
import java.util.Deque;

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

    public int minDiffInBSTWithStack(TreeNode root) {
        int prev = Integer.MIN_VALUE + 100000;
        int minValue = Integer.MAX_VALUE;

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;

        while(!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            minValue = Math.min(minValue, node.val - prev);
            prev = node.val;

            node = node.right;
        }
        return minValue;
    }
}
