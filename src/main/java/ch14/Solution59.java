package ch14;


public class Solution59 {

    public TreeNode dfs(int preIndex, int inStart, int inEnd, int[] preOrder, int[] inOrder) {
        if (preIndex > preOrder.length - 1 || inStart > inEnd) {
            return null;
        }

        int inIndex = 0; // Parent
        for (int i = inStart; i <= inEnd; i++) {
            if (inOrder[i] == preOrder[preIndex]) {
                inIndex = i;
            }
        }

        TreeNode node = new TreeNode(inOrder[inIndex]);
        preIndex++;
        node.left = dfs(preIndex, inStart, inIndex - 1, preOrder, inOrder);
        node.right = dfs(preIndex + inIndex - inStart, inIndex + 1, inEnd, preOrder, inOrder);
        return node;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(0, 0, inorder.length - 1, preorder, inorder);
    }
}
