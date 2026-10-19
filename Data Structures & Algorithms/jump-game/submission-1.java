class Solution {
    int dp[] = new int[1001];
    public boolean canJump(int[] nums) {
        Arrays.fill(dp, -1);
        return minJump(nums.length - 1, nums);
    }

    public boolean minJump(int index, int[] nums) {
        if(index == 0) return true;
        if(dp[index] != -1) return dp[index] == 1;
        boolean canReach = false;
        for(int i = 0; i < index; i++){
            // can reach
            if(i + nums[i] >= index) {
                canReach = canReach || minJump(i, nums);
            }
            if (canReach) break;
        }
        dp[index] = canReach == true ? 1: 0;
        return canReach;
    }
}
