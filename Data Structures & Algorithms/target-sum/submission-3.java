class Solution {
    int totalSum = 0;
    int dp[][];
    public int findTargetSumWays(int[] nums, int target) {
        for(int n : nums){
            totalSum += n;
        }
        dp = new int[2 * totalSum + 1][nums.length];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i], -1);
        }
        return solution(nums, target, nums.length - 1);
    }

    public int solution(int[] nums, int target, int index){
        if(index == 0){
            if (nums[0] == 0 && target == 0) return 2; // +0 and -0 are different solutions
            if(nums[index] == target || nums[index] == -target) return 1;
            return 0;
        }
        if(target < - totalSum || target > totalSum || index < 0) return 0;
        int targetIndex = getMapIndex(target);
        if(dp[targetIndex][index] != -1) return dp[targetIndex][index];
        return dp[targetIndex][index] = (solution(nums, target + nums[index], index - 1)
             + solution(nums, target - nums[index], index - 1));
    }

    private int getMapIndex(int value){
        return totalSum + value;
    }
}
