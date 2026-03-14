class Solution {
    int dp[][];
    int helper(int idx,int buy,int[] prices){
        int profit=0;
        if(idx>=prices.length){
            return 0;
        }
        if(dp[idx][buy]!=-1)
            return dp[idx][buy];
        if(buy==1){
            profit=Math.max(-prices[idx]+helper(idx+1,0,prices),0+helper(idx+1,1,prices));
        }
        else{
            profit=Math.max(prices[idx]+helper(idx+2,1,prices),0+helper(idx+1,0,prices));
        }
        return dp[idx][buy] = profit;
    }
    public int maxProfit(int[] prices) {
        dp = new int[prices.length+1][2];
        for(int[] r:dp)
            Arrays.fill(r,-1);
        return helper(0,1,prices);
    }
}