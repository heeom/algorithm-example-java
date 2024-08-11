package ch14;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution50 {

    // root노드에서부터 invert
    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode left = root.left;
            root.left = root.right;
            root.right = left;
            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }

    // leaf 노드에서부터 invert하면서 올라옴
    public TreeNode invertTreeSearchFirst(TreeNode root) {
        if (root != null) {
            invertTree(root.left);
            invertTree(root.right);

            TreeNode left = root.left;
            root.left = root.right;
            root.right = left;
        }
        return root;
    }

    public TreeNode invertTreeStack(TreeNode root) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return root;
    }
}
