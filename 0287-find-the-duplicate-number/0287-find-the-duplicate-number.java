class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int arr[] = new int[n+1];
        for(int ni:nums)
            arr[ni]++;
        for(int i=1;i<n+1;i++){
            if(arr[i]>=2)
                return i;
        }
        return -1;
    }
}