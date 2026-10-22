class Solution {
    int memo[][];
    public int maxProfit(int[] prices) {
        memo = new int[prices.length + 1][2];
        for(int i = 0; i < memo.length; i++){
            Arrays.fill(memo[i], -1);
        }
        return maxProfit(prices, 0, 1);
    }

    public int maxProfit(int[] prices, int index, int canBuy){
        if(index == prices.length) return 0;
        if(memo[index][canBuy] != -1) return memo[index][canBuy];
        if(canBuy == 1){
            return memo[index][canBuy] = Math.max(
                maxProfit(prices, index + 1, 0) - prices[index],
                maxProfit(prices, index + 1, 1));
        } else {
            return memo[index][canBuy]= Math.max(
                prices[index],
                maxProfit(prices, index + 1, 0));
        }
    }
}
