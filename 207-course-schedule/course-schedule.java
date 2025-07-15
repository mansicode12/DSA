class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
         ArrayList<Integer> result = new ArrayList<>();
        // step1 matrix covert into adjancey list
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i =0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge :prerequisites){
            int course = edge[0];
            int prerequisite = edge[1];
            graph.get(prerequisite).add(course);
        }
        int[] indegree = new int[numCourses];
        for(int u =0;u<numCourses;u++){
            for(int v: graph.get(u)){
                indegree[v]++;
            }
        }
       Queue<Integer> queue = new LinkedList<>();
        for(int i =0;i<numCourses;i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        int count = 0;
        while(!queue.isEmpty()){
            int course = queue.poll();
            count++;
            for(int neighbour : graph.get(course)){
                indegree[neighbour]--;
                if(indegree[neighbour] == 0){
                    queue.add(neighbour);
    }
}
        }
        return count == numCourses;
    }
}