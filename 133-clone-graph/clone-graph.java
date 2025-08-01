/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
     private Map<Node, Node> visited = new HashMap<>();
    public Node cloneGraph(Node node) {
         if (node == null) return null;

        // If this node is already cloned, return the clone
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // Clone the node (without neighbors for now)
        Node clone = new Node(node.val);
        visited.put(node, clone);

        // Clone all neighbors recursively
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }

        return clone;
    }
}
