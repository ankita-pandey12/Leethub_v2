class Solution {
    int dp[][];
    int helper(int i,int j,String s){
        if(i>=j)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        if(s.charAt(i)==s.charAt(j))
            return dp[i][j]=helper(i+1,j-1,s);
        else{
            return dp[i][j]=Math.min(1+helper(i+1,j,s),1+helper(i,j-1,s));
        }
    }
    public int minInsertions(String s) {
        dp= new int[s.length()][s.length()];
        for(int[] r: dp)
            Arrays.fill(r,-1);
        return helper(0,s.length()-1,s);
    }
}