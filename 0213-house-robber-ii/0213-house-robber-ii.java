class Solution {
    int dp[];
    int dp2[];
    public int max(int[] nums,int ind,int l,int[] dp){
        if(ind>l)    return 0;
        if(dp[ind]!=-1) return dp[ind];
        int steal= nums[ind]+max(nums,ind+2,l,dp);
        int skip = max(nums,ind+1,l,dp);
        dp[ind]=Math.max(steal,skip);
        return dp[ind];
    }
    public int rob(int[] nums) {
        if(nums.length==1)
            return nums[0];
        dp= new int[nums.length];
        dp2= new int[nums.length];
        Arrays.fill(dp,-1);
        Arrays.fill(dp2,-1);
        return Math.max(max(nums,0,nums.length-2,dp),max(nums,1,nums.length-1,dp2));
    }
}