class Solution {
    int[][] dp;
    int helper(int i,int j,int m,int n){
        if(i==m-1 && j==n-1)
            return 1;
        if(j>n-1 || i>m-1)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        int c1= helper(i,j+1,m,n);
        int c2 = helper(i+1,j,m,n);
        return dp[i][j] = c1+c2;
    }
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        for(int[] r : dp)
            Arrays.fill(r,-1);
        return helper(0,0,m,n);
    }
}