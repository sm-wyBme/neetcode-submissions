class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int i = 0; int j = n - 1;
        while(i <= j){
            int midpoint = i + (j - i)/2;
            if(nums[midpoint] == target) return midpoint;
            if(nums[midpoint] > target) j = midpoint - 1;
            else i = midpoint + 1;
        }
        return -1;
    }
}
