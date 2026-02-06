class Solution {
    public int jump(int[] nums) {
        int cnt=0;
        int curr=0;
        int maxIndex=0;
        for(int i=0;i<nums.length-1;i++){
            maxIndex=Math.max(maxIndex,i+nums[i]); //store farthest index you can reach
            if (i == curr) {   // jump required
                cnt++;
                curr = maxIndex;
            }
        }
        return cnt;
    }
}