class Solution {
    public int coinChange(int[] coins, int amount) {

        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -1);

        int minCoins = dfs(coins, amount, memo);

        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }

    public int dfs(int[] coins, int target, int[] memo) {

        if(target < 0)
            return Integer.MAX_VALUE;

        if(target == 0)
            return 0;

        if(memo[target] != -1)
            return memo[target];

        int minCoins = Integer.MAX_VALUE;

        for(int i = 0; i < coins.length; i++) {

            int result = dfs(coins, target - coins[i], memo);

            if(result != Integer.MAX_VALUE) {
                minCoins = Math.min(minCoins, 1 + result);
            }
        }

        memo[target] = minCoins;

        return minCoins;
    }
}