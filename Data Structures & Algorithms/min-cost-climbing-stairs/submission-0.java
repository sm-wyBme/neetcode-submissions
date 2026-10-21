class Solution {
    int memo[];
    public int minCostClimbingStairs(int[] cost) {
        memo = new int[cost.length + 1];
        Arrays.fill(memo, -1);
        return Math.min(minCost(cost, cost.length - 1), minCost(cost, cost.length - 2));
    }

    public int minCost(int[] cost, int index){
        if(index == 0) return cost[0];
        if(index == 1) return cost[1];
        if(memo[index] != -1) return memo[index];
        return memo[index] = cost[index] + Math.min(minCost(cost, index - 1), minCost(cost, index - 2));
    }
}
