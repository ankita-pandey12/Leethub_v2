class Solution {
    int dp[];
    public int max(int[] nums,int ind,int[] dp){
        if(ind>=nums.length)    return 0;
        if(dp[ind]!=-1) return dp[ind];
        int steal= nums[ind]+max(nums,ind+2,dp);
        int skip = max(nums,ind+1,dp);
        dp[ind]=Math.max(steal,skip);
        return dp[ind];
    }
    public int rob(int[] nums) {
        dp= new int[nums.length];
        Arrays.fill(dp,-1);
        return max(nums,0,dp);
    }
}