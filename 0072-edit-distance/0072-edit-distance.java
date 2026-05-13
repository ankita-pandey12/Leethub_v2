class Solution {
    int[][] dp;
    int helper(String word1, String word2, int i,int j){
        if(i==0)
            return j;
        if(j==0)
            return i;
        if(dp[i][j] != -1)
            return dp[i][j];
        
        if(word1.charAt(i-1)==word2.charAt(j-1))
            return dp[i][j]=helper(word1,word2,i-1,j-1);
        
        int insert = helper(word1,word2,i,j-1);
        int delete = helper(word1,word2,i-1,j);
        int replace = helper(word1,word2,i-1,j-1);

        int res = 1+Math.min(insert,Math.min(delete,replace));
        return dp[i][j]=res;
    }
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        dp = new int[n+1][m+1];

        for(int[] row : dp)
            Arrays.fill(row,-1);

        return helper(word1,word2,n,m);
    }
}