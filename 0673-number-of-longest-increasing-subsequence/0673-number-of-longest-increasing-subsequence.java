class Solution {
    int[][] dpLen;
    int[][] dpCount;
    int[] helper(int idx, int prev,int[] nums){
        if(idx==nums.length)
            return new int[]{0, 1};
        if(dpLen[idx][prev+1] != -1){
            return new int[]{dpLen[idx][prev+1], dpCount[idx][prev+1]};
        }
        int[] notTake = helper(idx+1, prev, nums);
        int takeLen = 0;
        int takeCount = 0;

        if(prev == -1 || nums[idx] > nums[prev]){
            int[] next = helper(idx+1, idx, nums);
            takeLen = 1 + next[0];
            takeCount = next[1];
        }

        int finalLen, finalCount;

        if(takeLen > notTake[0]){
            finalLen = takeLen;
            finalCount = takeCount;
        }
        else if(takeLen < notTake[0]){
            finalLen = notTake[0];
            finalCount = notTake[1];
        }
        else{
            finalLen = takeLen;
            finalCount = takeCount + notTake[1];
        }

        dpLen[idx][prev+1] = finalLen;
        dpCount[idx][prev+1] = finalCount;

        return new int[]{finalLen, finalCount};
    }
    public int findNumberOfLIS(int[] nums) {
        int n= nums.length;
        dpLen = new int[n][n+1];
        dpCount = new int[n][n+1];
        for(int[] r: dpLen)
            Arrays.fill(r,-1);
        return helper(0,-1,nums)[1];
    }
}