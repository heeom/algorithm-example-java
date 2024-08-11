package ch14;

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
}
