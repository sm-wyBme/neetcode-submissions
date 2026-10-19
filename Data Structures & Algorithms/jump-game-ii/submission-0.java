class Solution {
    int memo[] = new int[1001];
    public int jump(int[] nums) {
        Arrays.fill(memo, -1);
        return minJump(nums.length - 1, nums);
    }

    public int minJump(int index, int[] nums){
        if(index == 0) return 0;
        int min = Integer.MAX_VALUE;
        if(memo[index] != -1) return memo[index];
        for(int i = 0; i < index; i++) {
            // i can reach only if current position i + jump value >= index
            if(i + nums[i] >= index) {
                int value = minJump(i, nums);
                if(value != Integer.MAX_VALUE); 
                    min = Math.min(value + 1, min);
            }
        }
        return memo[index] = min;
    }
}
