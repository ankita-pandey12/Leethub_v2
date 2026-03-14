class Solution {
    int dp[][];
    int helper(int idx, int prev, int[] nums){
        if(idx == nums.length)
            return 0;
        if(dp[idx][prev+1] != -1)
            return dp[idx][prev+1];

        int cn1 = 0;
        if(prev == -1 || nums[idx] > nums[prev]){
            cn1 = 1 + helper(idx+1, idx, nums);
        }
        int cn2 = helper(idx+1, prev, nums);
        return dp[idx][prev+1] = Math.max(cn1, cn2);
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new int[n][n+1];
        for(int[] r : dp)
            Arrays.fill(r,-1);
        return helper(0, -1, nums);
    }
}
