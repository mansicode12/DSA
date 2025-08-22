import java.util.*;

class Solution {
    private int m, n;
    private int[][] heights;
    private final int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        m = heights.length;
        n = heights[0].length;
        
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        
        // Start DFS from all Pacific-bordering cells
        for (int i = 0; i < m; i++) {
            dfs(i, 0, pacific);      // Left edge (Pacific)
            dfs(i, n-1, atlantic);   // Right edge (Atlantic)
        }
        for (int j = 0; j < n; j++) {
            dfs(0, j, pacific);      // Top edge (Pacific)
            dfs(m-1, j, atlantic);   // Bottom edge (Atlantic)
        }
        
        // Find intersection
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        
        return result;
    }
    
    private void dfs(int r, int c, boolean[][] visited) {
        if (visited[r][c]) return;
        visited[r][c] = true;
        
        for (int[] d : directions) {
            int nr = r + d[0];
            int nc = c + d[1];
            if (nr < 0 || nc < 0 || nr >= m || nc >= n) continue;
            if (heights[nr][nc] < heights[r][c]) continue;  // must go higher/equal
            dfs(nr, nc, visited);
        }
    }
}
