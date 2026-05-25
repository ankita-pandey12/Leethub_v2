class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        boolean dp[] = new boolean[n];
        dp[0]=true;

        for( int i=1;i<n;i++){
            if(s.charAt(i)=='1')
                continue;
            for(int j=Math.max(0,i-maxJump);j<=i-minJump;j++){
                if(dp[j]){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[n-1];
    }
}