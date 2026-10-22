class Solution {
    int memo[][];
    public int maxProfit(int[] prices) {
        memo = new int[prices.length + 1][2];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return buyOrSell(prices, 0, 1);
    }

    public int buyOrSell(int prices[], int index, int canBuy){
        if(index >= prices.length) return 0;
        if(memo[index][canBuy] != -1) return memo[index][canBuy];
        if(canBuy == 1){
            return memo[index][canBuy] = Math.max(
                buyOrSell(prices, index + 1, 1),
                buyOrSell(prices, index + 1, 0) - prices[index]
            );
        }else{
            return memo[index][canBuy] = Math.max(
                buyOrSell(prices, index + 1, 0),
                buyOrSell(prices, index + 2, 1) + prices[index] //one day cooldown
            );
        }
    }
}
