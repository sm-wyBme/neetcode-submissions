class Solution {
    int memo[];
    public int climbStairs(int n) {
        memo = new int[n+1];
        Arrays.fill(memo, -1);
        return climbStair(n);
    }

    public int climbStair(int n) {
        if(n <= 2) return n;
        if(memo[n] != -1) return memo[n];
        return memo[n] = climbStair(n - 1) + climbStair(n - 2);
    }
}
