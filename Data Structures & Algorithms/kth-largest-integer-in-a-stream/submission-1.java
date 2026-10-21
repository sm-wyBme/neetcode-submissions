
class KthLargest {
    int capacity;
    PriorityQueue<Integer> minHeap;

    public KthLargest(int k, int[] nums) {
        capacity = k;
        minHeap = new PriorityQueue<>();

        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (minHeap.size() < capacity) {
            minHeap.add(val);
        } else if (val > minHeap.peek()) {
            minHeap.poll();
            minHeap.add(val);
        }

        return minHeap.peek();
    }
}
