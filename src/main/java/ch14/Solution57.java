package ch14;

import com.sun.source.tree.Tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

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

    public int rangeSumBSTWithQueue(TreeNode root, int low, int high) {
        Queue<TreeNode> queue = new LinkedList<>();
        int result = 0;
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.val > low && node.left != null) {
                queue.offer(node.left);
            }
            if (node.val < high && node.right != null) {
                queue.offer(node.right);
            }

            if (node.val <= high && node.val >= low) {
                result += node.val;
            }
        }
        return result;
    }


}
