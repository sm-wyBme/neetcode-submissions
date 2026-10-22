class Solution {
    int dp[][];
    public int change(int amount, int[] coins) {
        dp = new int[amount + 1][coins.length + 1];
        Arrays.fill(dp[0], 1);
        Arrays.sort(coins);

        for(int i = 1; i <= amount; i++){
            for(int j = 1; j <= coins.length; j++){
                if(i - coins[j-1] >= 0){
                    dp[i][j] = dp[i - coins[j-1]][j] + dp[i][j-1];
                } else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[amount][coins.length];
    }
}
