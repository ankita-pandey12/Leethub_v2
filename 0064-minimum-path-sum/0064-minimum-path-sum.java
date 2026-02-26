class Solution {
    int[][] dp;
    int helper(int i, int j, int m, int n, int[][] grid) {
        if (i > m || j > n)
            return Integer.MAX_VALUE;
        if (i == m && j == n)
            return grid[i][j];
        if (dp[i][j] != -1)
            return dp[i][j];
        int down = helper(i + 1, j, m, n, grid);
        int right = helper(i, j + 1, m, n, grid);
        dp[i][j] = grid[i][j] + Math.min(down, right);
        return dp[i][j];
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length - 1;
        int n = grid[0].length - 1;
        dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++)
            Arrays.fill(dp[i], -1);
        return helper(0, 0, m, n, grid);
    }
}