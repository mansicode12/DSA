/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode recoverFromPreorder(String traversal) {
        Deque<TreeNodeDepth> stack = new ArrayDeque<>();
        int i = 0, n = traversal.length();

        while (i < n) {
            int depth = 0;

            // Count dashes to get depth
            while (i < n && traversal.charAt(i) == '-') {
                depth++;
                i++;
            }

            // Read the number (node value)
            int val = 0;
            while (i < n && Character.isDigit(traversal.charAt(i))) {
                val = val * 10 + (traversal.charAt(i) - '0');
                i++;
            }

            TreeNode node = new TreeNode(val);

            // Pop until we find correct parent
            while (stack.size() > depth) {
                stack.pop();
            }

            // Attach this node to its parent (if exists)
            if (!stack.isEmpty()) {
                TreeNode parent = stack.peek().node;
                if (parent.left == null) {
                    parent.left = node;
                } else {
                    parent.right = node;
                }
            }

            stack.push(new TreeNodeDepth(node, depth));
        }

        // Root is the last element in the bottom of the stack
        while (stack.size() > 1) stack.pop();
        return stack.peek().node;
    }

    // Helper class to keep node and its depth
    static class TreeNodeDepth {
        TreeNode node;
        int depth;
        TreeNodeDepth(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
}