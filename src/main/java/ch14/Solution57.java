package ch14;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution57 {
    private int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return sum;
        }
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }

        sum += root.val;
        rangeSumBST(root.left, low, high);
        rangeSumBST(root.right, low, high);
        return sum;
    }

    public int rangeSumBSTWithStack(TreeNode root, int low, int high) {
        Deque<TreeNode> stack = new ArrayDeque<>();

        stack.push(root);
        int result = 0;

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.val > low && node.left != null) {
                stack.push(node.left);
            }
            if (node.val < high && node.right != null) {
                stack.push(node.right);
            }
            if (node.val <= high && node.val >= low) {
                result += node.val;
            }
        }
        return result;
    }


}
