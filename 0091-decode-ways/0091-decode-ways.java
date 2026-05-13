class Solution {
    int dp[];
    int helper(String s, int i){
        if(i==s.length())
            return 1;
        if(s.charAt(i)=='0')
            return 0;
        if(dp[i]!=-1)
            return dp[i];
        int single = helper(s,i+1);
        int twoDigit =0;
        if(i+1 < s.length()){
            int num = (s.charAt(i)-'0') * 10 +
                (s.charAt(i+1)-'0');

            if(num >= 10 && num <= 26){
                twoDigit = helper(s, i + 2);
            }
        }
        int res = single+twoDigit;
        return dp[i]=res;
    }
    public int numDecodings(String s) {
         dp = new int[s.length()];
        Arrays.fill(dp, -1);

        return helper(s, 0);
    }
}