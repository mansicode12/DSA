import java.util.*;

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        int left = 0, right = 1_000_000; // max height difference possible
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canReachEnd(heights, mid)) {
                result = mid;      // mid is possible, try smaller
                right = mid - 1;
            } else {
                left = mid + 1;    // mid too small, increase
            }
        }

        return result;
    }

    private boolean canReachEnd(int[][] heights, int maxEffort) {
        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] visited = new boolean[rows][cols];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1];

            if (x == rows - 1 && y == cols - 1) {
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < rows && ny < cols && !visited[nx][ny]) {
                    int diff = Math.abs(heights[nx][ny] - heights[x][y]);
                    if (diff <= maxEffort) {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        return false; // destination not reachable under this maxEffort
    }
}
