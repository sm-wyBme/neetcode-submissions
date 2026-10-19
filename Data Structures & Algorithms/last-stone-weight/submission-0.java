class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int stone: stones) {
            maxHeap.add(stone);
        }

        while(maxHeap.size() > 1){
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();
            int value = Math.abs(stone1 - stone2);
            if(value != 0) maxHeap.add(value);
        }

        return (maxHeap.size() == 1)? maxHeap.poll(): 0;
    }
}
