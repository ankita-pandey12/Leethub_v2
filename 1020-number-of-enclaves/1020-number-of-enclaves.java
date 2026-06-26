class Solution {
    int cnt = 0; 

    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int totalEnclaves = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    cnt = 0;
                    
                    if (dfs(i, j, grid, visited)) {
                        totalEnclaves += cnt;
                    }
                }
            }
        }
        return totalEnclaves;
    }

    private boolean dfs(int i, int j, int[][] grid, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;

        if (i < 0 || i >= m || j < 0 || j >= n) {
            return false; 
        }
        if (grid[i][j] == 0 || visited[i][j]) {
            return true; 
        }

        visited[i][j] = true;
        cnt++; 
        boolean up = dfs(i - 1, j, grid, visited);
        boolean down = dfs(i + 1, j, grid, visited);
        boolean left = dfs(i, j - 1, grid, visited);
        boolean right = dfs(i, j + 1, grid, visited);

        return up && down && left && right;
    }
}
