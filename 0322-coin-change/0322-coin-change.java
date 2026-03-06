class Solution {
    int[] dp;
    public int helper(int coins[],int amt){
        if(amt == 0)
            return 0;
        if(amt < 0)
            return Integer.MAX_VALUE;
        if(dp[amt-1]!=-1)
            return dp[amt-1];
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++){
            int res = helper(coins, amt - coins[i]);
            if(res != Integer.MAX_VALUE){
                min = Math.min(min, res + 1);
            }
        }
        return dp[amt-1] = min;
    }
    public int coinChange(int[] coins, int amount) {
        dp=new int[amount];
        Arrays.fill(dp,-1);
        int ans = helper(coins, amount);
        if(ans == Integer.MAX_VALUE)
            return -1;
        return ans;
    }
}