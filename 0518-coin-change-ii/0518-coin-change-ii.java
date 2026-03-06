class Solution {
    int dp[][];

    public int change(int amount, int[] coins) {
        dp = new int[amount + 1][coins.length];

        for (int[] r : dp)
            Arrays.fill(r, -1);

        return helper(coins, amount, 0, 0);
    }

    public int helper(int coins[], int amt, int sum, int idx) {

        if (sum == amt)
            return 1;

        if (sum > amt || idx == coins.length)
            return 0;

        if (dp[sum][idx] != -1)
            return dp[sum][idx];

        int take = helper(coins, amt, sum + coins[idx], idx);
        int skip = helper(coins, amt, sum, idx + 1);

        return dp[sum][idx] = take + skip;
    }
}