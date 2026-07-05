class Solution {
    public int countPrimes(int n) {
        boolean[] ans = new boolean[n];
        for(int i=2;i<n;i++){
            ans[i]=true;
        }
        int cnt =0;
        for(int i=2;i<n;i++){
            if(ans[i]){
            cnt++;
            for(int j=i*2;j<n;j+=i){
                ans[j]=false;
            }
            }
        }
        return cnt;
    }
}