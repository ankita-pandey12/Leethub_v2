class Solution {
    public int[] rearrangeArray(int[] nums) {
        int pos=0,neg=1;
        int[] nums1=new int[nums.length];
        for(int i:nums){
            if(i<0 && neg<nums.length){
                nums1[neg]=i;
                neg=neg+2;
            }
            else if(pos<nums.length){
                nums1[pos]=i;
                pos=pos+2;
            }
        }
        return nums1;
    }
}