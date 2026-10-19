class Solution {
    public int maxProduct(int[] nums) {
        int globalMaxProduct = nums[0];
        int max = 1;
        int min = 1;

        for(int i : nums){
            int temp = max;
            max = Math.max(Math.max(max * i, min * i), i);
            min = Math.min(Math.min(temp * i, min * i), i);
            globalMaxProduct = Math.max(max, globalMaxProduct);
        }

        return globalMaxProduct;
    }
}
