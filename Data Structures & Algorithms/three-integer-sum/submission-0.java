class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int low = i + 1;
            int high = nums.length - 1;
            while(low < high){
                int sum = nums[i] + nums[low] + nums[high];
                if(sum > 0) {
                    high--;
                } else if(sum < 0){
                    low++;
                }else{
                    results.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    low++;
                    high--;
                    //skip duplicates
                    while(low < high && nums[low] == nums[low-1]){
                        low++;
                    }
                }
            }
        }
        return results;
    }
}
