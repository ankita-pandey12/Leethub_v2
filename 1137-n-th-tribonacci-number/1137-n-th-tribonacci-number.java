class Solution {
    int dp[];
    int tribonacc(int n){
        if(n==0)
            return dp[0]=0;
        if(n<=2)
            return dp[n]=1;
        if(dp[n]!=-1)
            return dp[n];
        return dp[n]=tribonacc(n-1)+tribonacc(n-2)+tribonacc(n-3);
    }
    public int tribonacci(int n) {
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        tribonacc(n);
        return dp[n];
    }
}