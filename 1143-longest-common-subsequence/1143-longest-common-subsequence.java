class Solution {
    int dp[][];
    int helper(int i,int j,String s1,String s2){
        if(i==s1.length() || j==s2.length()){
            return 0;
        }
        if(dp[i][j]!=-1)
            return dp[i][j];
        int ans =0;
        if(s1.charAt(i)==s2.charAt(j))
            return dp[i][j] = 1+helper(i+1,j+1,s1,s2);
        else{
            ans=Math.max(helper(i+1,j,s1,s2),helper(i,j+1,s1,s2));
        }
        return dp[i][j]=ans;
    }
    public int longestCommonSubsequence(String text1, String text2) {
        dp=new int[text1.length()][text2.length()];
        for(int[] r:dp)
            Arrays.fill(r,-1);
        return helper(0,0,text1,text2);
    }
}