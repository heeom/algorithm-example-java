package ch14;


public class Solution48 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, null, null), null);
        Solution48 solution48 = new Solution48();
        int result = solution48.diameterOfBinaryTree(root);
        System.out.println(result);
    }
    static int longest = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        dfs(root);

        return longest;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return -1;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);
        longest = Math.max(longest, left + right + 2); // left에서 리프노드까지 거리 + right에서 리프노드까지 거리 + root(계속 변경된다)에서 left, right 까지 거리 2
        return Math.max(left, right) + 1;
    }
}
