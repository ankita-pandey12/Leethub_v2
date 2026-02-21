class Solution {
    int dp[];
    int c(int s,int n,int dp[]){
        if(s==n)
            return 1;
        if(s>n)
            return 0;
        if(dp[s]!=-1)
            return dp[s];
        dp[s]=c(s+1,n,dp)+c(s+2,n,dp);
        return dp[s];
    }
    public int climbStairs(int n) {
        dp=new int[n];
        Arrays.fill(dp,-1);
        c(0,n,dp);
        return dp[0];
    }
}