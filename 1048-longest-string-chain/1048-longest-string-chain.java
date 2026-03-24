class Solution {
    int dp[][];
    Boolean check(int idx,int prev,String[] words){
        String s1=words[idx];
        String s2=words[prev];
        if(s1.length()!=s2.length()+1)
            return false;
        int i=0,j=0;
        while(i < s1.length()){
            if(j < s2.length() && s1.charAt(i) == s2.charAt(j)){
            i++; j++;
        } else {
            i++; 
            }
        }
        return j==s2.length();
    }
    int helper(int idx,int prev,String[] words){
        if(idx==words.length)
            return 0;
        if(dp[idx][prev+1]!=-1)
            return dp[idx][prev+1];
        int take =0;
        if(prev==-1 || check(idx,prev,words)){
            take=1+helper(idx+1,idx,words);
        }
        int nontake = helper(idx+1,prev,words);
        int res = (take>=nontake)?take:nontake;
        return dp[idx][prev+1] = res;
    }
    public int longestStrChain(String[] words) {
        int n = words.length;
        dp=new int[n][n+1];
        for(int[] r: dp)
            Arrays.fill(r,-1);
        Arrays.sort(words, (a,b) -> a.length() - b.length());
        return helper(0,-1,words);
    }
}