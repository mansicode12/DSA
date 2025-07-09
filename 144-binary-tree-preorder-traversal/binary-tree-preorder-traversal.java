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
     public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode currentNode = stack.pop();
            list.add(currentNode.val);
            if(currentNode.right!= null){
                stack.push(currentNode.right);
            }
             if(currentNode.left!= null){
                stack.push(currentNode.left);
            }
        }
return list;
     }
    // recursive
    public List<Integer> RecpreorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preOrderHelper(root,list);
        return list;
    }
       void preOrderHelper(TreeNode root,List<Integer> result){
          if(root == null){
            return;
        }
        result.add(root.val);
        preOrderHelper(root.left,result);
         preOrderHelper(root.right,result);
        }
}