class Solution {
    int dp[][];
    public int change(int amount, int[] coins) {
        dp = new int[amount + 1][coins.length + 1];
        for(int i[]: dp){
            Arrays.fill(i, -1);
        }
        Arrays.sort(coins);
        return helper(amount, coins, coins.length - 1);
    }

    public int helper(int target, int[] coins, int index){
        if(target == 0) return 1;
        if(index < 0) return 0;
        if(dp[target][index] != -1) return dp[target][index];
        if(target - coins[index] >= 0){
            return dp[target][index] = helper(target - coins[index], coins, index) 
                + helper(target, coins, index - 1);
        }
        return dp[target][index] = helper(target, coins, index - 1);
    }
}
