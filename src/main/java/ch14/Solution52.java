package ch14;

import java.util.LinkedList;
import java.util.Queue;

public class Solution52 {

    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "";
            }
            StringBuffer sb = new StringBuffer();
            Queue<TreeNode> queue = new LinkedList<>();

            queue.add(root);
            sb.append("#,").append(root.val);

            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                    sb.append(",").append(node.left.val);
                } else {
                    sb.append(",#");
                }
                if (node.right != null) {
                    queue.add(node.right);
                    sb.append(",").append(node.right.val);
                } else {
                    sb.append(",#");
                }
            }
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if ("".equals(data)) {
                return null;
            }
            String[] nodes = data.split(",");
            TreeNode root = new TreeNode(Integer.parseInt(nodes[1]));

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int idx = 2;
            while (!queue.isEmpty()) {
                TreeNode parent = queue.poll();
                if (!nodes[idx].equals("#")) {
                    parent.left = new TreeNode(Integer.parseInt(nodes[idx]));
                    queue.add(parent.left);
                }
                idx++;
                if (!nodes[idx].equals("#")) {
                    parent.right = new TreeNode(Integer.parseInt(nodes[idx]));
                    queue.add(parent.right);
                }
                idx++;
            }
            return root;
        }
    }
}
