class Solution {
    int dp[][];
    int helper(int i,int j,String s,String t){
        if(j==t.length())
            return 1;
        if(i==s.length()){
            return 0;
        }
        if(dp[i][j]!=-1)
            return dp[i][j];
        int take =0;
        if(s.charAt(i)==t.charAt(j))
            take = helper(i+1,j+1,s,t);
        int skip = helper(i+1,j,s,t);
        return dp[i][j]=take+skip;
    }
    public int numDistinct(String s, String t) {
        dp = new int[s.length()][t.length()];
        for(int[] r: dp)
            Arrays.fill(r,-1);
        return helper(0,0,s,t);
    }
}