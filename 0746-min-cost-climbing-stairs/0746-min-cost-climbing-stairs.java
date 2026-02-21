class Solution {
    int dp[];
    public int min(int[] cost,int ind,int[] dp){
        if(ind>=cost.length)    return 0;
        if(dp[ind]!=-1)     return dp[ind];
        int one=cost[ind]+min(cost,ind+1,dp);
        int two=cost[ind]+min(cost,ind+2,dp);
        return dp[ind]=Math.min(one,two);
    }
    public int minCostClimbingStairs(int[] cost) {
        dp=new int[cost.length];
        Arrays.fill(dp,-1);
        return Math.min(min(cost,0,dp),min(cost,1,dp));
    }
}