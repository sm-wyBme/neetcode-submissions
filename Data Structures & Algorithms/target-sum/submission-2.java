class Solution {
    int totalSum = 0;
    HashMap<String, Integer> map;
    public int findTargetSumWays(int[] nums, int target) {
        for(int n : nums){
            totalSum += n;
        }
        map = new HashMap<>();
        return solution(nums, target, nums.length - 1);
    }

    public int solution(int[] nums, int target, int index){
        if(index == 0){
            if (nums[0] == 0 && target == 0) return 2; // +0 and -0 are different solutions
            if(nums[index] == target || nums[index] == -target) return 1;
            return 0;
        }
        if(target < - totalSum || target > totalSum || index < 0) return 0;
        String mapKey = createKey(target, index);
        if(map.containsKey(mapKey)) return map.get(mapKey);
        int value = solution(nums, target + nums[index], index - 1)
             + solution(nums, target - nums[index], index - 1);
        map.put(mapKey, value);
        return value;
    }

    public String createKey(int value1, int value2){
        String key = value1 + "#" + value2;
        //System.out.println("key : " + key);
        return key;
    }
}
