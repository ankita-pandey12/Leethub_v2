class Solution {
    int helper(int[] nums,int target,int sum,int idx){
        if(idx==nums.length){
            if(sum==target)
                return 1;
            return 0;
        }
        int cnt1 = helper(nums,target,sum+nums[idx],idx+1);
        int cnt2 = helper(nums,target,sum-nums[idx],idx+1);
        return cnt1+cnt2;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int count=helper(nums,target,0,0);
        return count;
    }
}