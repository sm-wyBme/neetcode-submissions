class Solution {
    int memo[];
    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return robMe(nums, nums.length - 1);
    }

    public int robMe(int[] nums, int index){
        if(index == 0) return nums[0];
        if(index == 1) return Math.max(nums[0], nums[1]);
        if(memo[index] != -1) return memo[index];
        return memo[index] = Math.max(nums[index] + robMe(nums, index - 2), robMe(nums, index - 1));
    }
}
