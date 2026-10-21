class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i : nums){
            if(minHeap.size() >= k){
                if(minHeap.peek() < i){
                    minHeap.poll();
                }else{
                    continue;
                }
            }
            minHeap.add(i);
        }
        return minHeap.peek();
    }
}
