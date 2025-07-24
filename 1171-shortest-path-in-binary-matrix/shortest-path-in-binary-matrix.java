class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
       int n = grid.length;
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) {
            return -1;
        }
        int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1});
         grid[0][0] = 1;
           while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1], dist = curr[2];

            if (x == n - 1 && y == n - 1) {
                return dist; // Reached destination
            }
            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i], ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n && grid[nx][ny] == 0) {
                    queue.offer(new int[]{nx, ny, dist + 1});
                    grid[nx][ny] = 1; // Mark as visited
                }
            }
        }

        return -1; // No path found
    }
}