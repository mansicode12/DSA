class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // step1 we build the adj list and fill it (vertex and edges)
        List<List<Integer>> graph = new ArrayList<>();
        for(int i =0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        // get the edges
        for(int [] edge:edges){
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
   boolean visited[] = new boolean[n];
    return dfs(source,destination,graph,visited);
    }
  boolean  dfs(int currentNode,int dest,List<List<Integer>> graph, boolean visited[]){
    if(currentNode == dest){
        return true;
    }
    visited[currentNode] = true;// mark this node as visited
    for(int neighbour : graph.get(currentNode)){
        if(!visited[neighbour]){
            if(dfs(neighbour,dest,graph,visited)){
                return true;
            }
        }
    }
    return false;
    }
}