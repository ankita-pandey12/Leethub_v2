class Solution {
    public int[] leftRightDifference(int[] nums) {
        int[] ans = new int[nums.length];
        if(nums.length==0)
            return ans;
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        left[0]=0;
        int sum1=nums[0];
        for(int i=1;i<nums.length;i++){
            left[i]=sum1;
            sum1+=nums[i];
        }
        right[nums.length-1]=0;
        int sum2=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            right[i]=sum2;
            sum2+=nums[i];
        }
       
        for(int i=0;i<nums.length;i++){
            ans[i]=Math.abs(left[i]-right[i]);
        }
        return ans;
    }
}