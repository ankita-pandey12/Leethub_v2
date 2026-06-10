class Solution {

    Boolean[][] dp;
    boolean helper(int i, int j, String s, String p) {
        if (i == s.length() && j == p.length())
            return true;
        if (j == p.length())
            return false;
        if (dp[i][j] != null)
            return dp[i][j];
        if (i == s.length()) {
            for (int k = j; k < p.length(); k++) {
                if (p.charAt(k) != '*')
                    return dp[i][j] = false;
            }
            return dp[i][j] = true;
        }

        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')
            return dp[i][j] = helper(i + 1, j + 1, s, p);

        if (p.charAt(j) == '*')
            return dp[i][j] =
                    helper(i, j + 1, s, p) ||  
                    helper(i + 1, j, s, p);   

        return dp[i][j] = false;
    }

    public boolean isMatch(String s, String p) {
        dp = new Boolean[s.length() + 1][p.length() + 1];
        return helper(0, 0, s, p);
    }
}