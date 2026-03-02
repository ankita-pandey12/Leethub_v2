class Solution {
    Boolean[][] dp;
    int total;
    public boolean helper(int idx,int sum1,int sum2,int[] nums){
        if(idx==nums.length){
            return sum1 == sum2;
        }
        if(dp[idx][sum1] != null)
            return dp[idx][sum1];
        boolean first = helper(idx+1,sum1+nums[idx],sum2,nums);
        boolean second = helper(idx+1,sum1,sum2+nums[idx],nums);
        return dp[idx][sum1] = first || second;
    }

    public boolean canPartition(int[] nums) {
        total = 0;
        for(int x : nums) total += x;
        dp = new Boolean[nums.length][total+1];
        return helper(0,0,0,nums);
    }
}