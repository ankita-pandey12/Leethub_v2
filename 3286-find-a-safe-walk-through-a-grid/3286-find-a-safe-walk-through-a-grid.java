class Solution {
    private boolean[][] vis;
    private Boolean[][][] dp;

    public boolean check(List<List<Integer>> grid, int row, int col, int hlt) {
        int m = grid.size();
        int n = grid.get(0).size();

        if (row >= m || col >= n || row < 0 || col < 0 || hlt <= 0 || vis[row][col]) {
            return false;
        }

        if (row == m - 1 && col == n - 1) {
            return hlt > grid.get(row).get(col);
        }

        if (dp[row][col][hlt] != null) {
            return dp[row][col][hlt];
        }

        vis[row][col] = true;
        int currentCost = grid.get(row).get(col);

        boolean up = check(grid, row - 1, col, hlt - currentCost);
        boolean dw = check(grid, row + 1, col, hlt - currentCost);
        boolean lf = check(grid, row, col - 1, hlt - currentCost);
        boolean rf = check(grid, row, col + 1, hlt - currentCost);

        vis[row][col] = false;

        boolean result = up || dw || lf || rf;
        dp[row][col][hlt] = result;

        return result;
    }

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();

        dp = new Boolean[m][n][health + 1];
        vis = new boolean[m][n];

        return check(grid, 0, 0, health);
    }
}
