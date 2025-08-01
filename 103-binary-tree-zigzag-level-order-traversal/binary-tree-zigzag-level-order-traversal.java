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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> bigList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return bigList;
        }
        queue.add(root);
        int level =0;
        while(!queue.isEmpty()){
int levelSize = queue.size();
List<Integer> smallList = new ArrayList<>();
level++;
for(int i =0;i<levelSize;i++){
    TreeNode currentNode = queue.remove();
    smallList.add(currentNode.val);
    if(currentNode.left != null){
        queue.add(currentNode.left);
    }
    if(currentNode.right!= null){
        queue.add(currentNode.right);
    }
}        
if(level %2==0){
    Collections.reverse(smallList);
}
bigList.add(smallList);
}
return bigList;
    }
}