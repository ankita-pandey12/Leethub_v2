class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n=grid.length;
        int[] dp = new int[n];
        for(int i=0;i<n;i++)
            dp[i]=grid[n-1][i];
        for(int i=n-2;i>=0;i--){
            int temp[] = new int[n];
            for(int j=0;j<=n-1;j++){
                if(j==0){
                    temp[j]=grid[i][j]+Math.min(dp[j],dp[j+1]);
                }
                else if(j==n-1){
                    temp[j]=grid[i][j]+Math.min(dp[j],dp[j-1]);
                }
                else
                    temp[j]=grid[i][j]+Math.min(dp[j],Math.min(dp[j-1],dp[j+1]));
            }
            dp=temp;
        }
        int mini = dp[0];
        for(int i=1;i<n;i++){
            mini = Math.min(mini,dp[i]);
        }
        return mini;
    }
}