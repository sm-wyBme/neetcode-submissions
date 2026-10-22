class Solution {
    public int maxProfit(int[] prices) {
        return maxProfit(prices, 0, 1);
    }

    public int maxProfit(int[] prices, int index, int canBuy){
        if(index == prices.length) return 0;
        if(canBuy == 1){
            return Math.max(
                maxProfit(prices, index + 1, 0) - prices[index],
                maxProfit(prices, index + 1, 1));
        } else {
            return Math.max(
                prices[index],
                maxProfit(prices, index + 1, 0));
        }
    }
}
