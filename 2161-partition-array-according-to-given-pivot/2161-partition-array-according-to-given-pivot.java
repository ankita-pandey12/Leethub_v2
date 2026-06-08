class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] arr1 = new int[nums.length];
        int i=0;
        for(int n:nums){
            if(n<pivot){
                arr1[i]=n;
                i++;
            }
        }
        for(int n:nums){
            if(n==pivot){
                arr1[i]=n;
                i++;
            }
        }
        for(int n:nums){
            if(n>pivot){
                arr1[i]=n;
                i++;
            }
        }
        return arr1;
    }
}