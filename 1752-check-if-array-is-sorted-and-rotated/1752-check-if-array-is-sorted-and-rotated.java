class Solution {
    public boolean check(int[] nums) {
        int flag =0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[i-1])
                flag++;
        }
        if(flag>1)
            return false;
        if(flag==1){
            if(nums[nums.length-1]<=nums[0])
                return true;
            else return false;
        }
        return true;
    }
}