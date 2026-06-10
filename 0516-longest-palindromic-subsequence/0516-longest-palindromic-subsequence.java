class Solution {
    int dp[][];
    int helper(int i,int j,String s){
        if(i> j)
            return 0;
        if(i==j)
            return 1;
        if(dp[i][j]!=-1)
            return dp[i][j];
        int nottake =0;
        if(s.charAt(i)==s.charAt(j))
            return dp[i][j]=2+helper(i+1,j-1,s);
        else{
            nottake = Math.max(helper(i+1,j,s),helper(i,j-1,s));
        }
        return dp[i][j]=nottake;
    }

    public int longestPalindromeSubseq(String s) {
        if(s.length()==1)
            return 1;
        dp= new int[s.length()][s.length()];
        for(int r[] : dp)
            Arrays.fill(r,-1);
        return helper(0,s.length()-1,s);
    }
}