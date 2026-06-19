class Solution {
    public int largestAltitude(int[] gain) {
        int[] alt = new int[gain.length+1];
        alt[0]=0;
        alt[1]=gain[0];
        for(int i=1;i<gain.length;i++){
            alt[i+1]=gain[i]+alt[i];
        }
        int max=Integer.MIN_VALUE;
        for(int n:alt){
            max=Math.max(max,n);
        }
        return max;
    }
}