package ch14;


public class Solution49 {
    int longest = 0;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return longest;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);

        if (node.left != null && node.left.val == node.val) {
            left += 1;
        } else {
            left = 0; // 부모노드와 값이 같지 않으면 초기화
        }

        if (node.right != null && node.right.val == node.val) {
            right += 1;
        } else {
            right = 0;
        }

        this.longest = Math.max(this.longest, left + right);

        return Math.max(right, left);
    }
}
