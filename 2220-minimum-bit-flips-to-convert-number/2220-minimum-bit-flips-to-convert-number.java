class Solution {
    public int minBitFlips(int start, int goal) {
        int res = start^goal;
        int cnt=0;
        while(res>0){
            int k = res%2;
            if(k==1)
                cnt++;
            res=res/2;
        }
        return cnt;
    }
}