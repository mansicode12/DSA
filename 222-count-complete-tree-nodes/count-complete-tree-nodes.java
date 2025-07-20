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
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = getHeight(root, true);
        int rightHeight = getHeight(root, false);
         if (leftHeight == rightHeight) {
             return (1 << leftHeight) - 1;
        } else {
            // Recurse on left and right
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    // Helper function to compute the height
    private int getHeight(TreeNode node, boolean goLeft) {
        int height = 0;
        while (node != null) {
            height++;
            node = goLeft ? node.left : node.right;
        }
        return height;
    }
}  