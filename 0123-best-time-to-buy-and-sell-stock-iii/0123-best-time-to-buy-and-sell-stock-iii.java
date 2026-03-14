class Solution {
    int dp[][][];
    int helper(int idx,int buy,int[] prices,int cap){
        int profit =0;
        if(cap==0)
            return 0;
        if(idx==prices.length)
            return 0;
        if(dp[idx][buy][cap]!=-1)
            return dp[idx][buy][cap];
        if(buy==1){
            profit=Math.max(-prices[idx]+helper(idx+1,0,prices,cap),0+helper(idx+1,1,prices,cap));
        }
        else{
            profit=Math.max(prices[idx]+helper(idx+1,1,prices,cap-1),0+helper(idx+1,0,prices,cap));
        }
         return dp[idx][buy][cap] = profit;
    }
    public int maxProfit(int[] prices) {
        dp = new int[prices.length][2][3];
        for(int i=0;i<prices.length;i++){
            for(int j=0;j<2;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return helper(0,1,prices,2);
    }
}