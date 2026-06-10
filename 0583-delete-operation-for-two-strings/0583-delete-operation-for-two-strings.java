class Solution {
    int dp[][];
    int helper(int i,int j,String s1,String s2){
        if(i == s1.length())
            return s2.length() - j;
        if(j == s2.length())
            return s1.length() - i;
        if(dp[i][j]!=-1)
            return dp[i][j];
        int ams =0;
        if(s1.charAt(i)==s2.charAt(j))
            return dp[i][j]=helper(i+1,j+1,s1,s2);
        else{
            ams = Math.min(1+helper(i+1,j,s1,s2),1+helper(i,j+1,s1,s2));
        }
        return dp[i][j]=ams;
    }
    public int minDistance(String word1, String word2) {
        dp = new int[word1.length()+1][word2.length()+1];
        for(int[] r: dp)
            Arrays.fill(r,-1);
        return helper(0,0,word1,word2);
    }
}