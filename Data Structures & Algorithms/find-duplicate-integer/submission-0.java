class Solution {
    public int findDuplicate(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            int value = Math.abs(nums[i]);
            if(nums[value - 1] < 0) return value;
            else nums[value - 1] = nums[value - 1] * -1;
        }
        return -1;
    }
}
