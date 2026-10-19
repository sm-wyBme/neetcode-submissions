class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Comparator<int[]> distanceComparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] s1, int[] s2) {
                return Double.compare(distance(s1[0], s1[1]), distance(s2[0], s2[1]));
            }
        };
        Queue<int[]> minHeap = new PriorityQueue<>(distanceComparator);
        for(int[] row: points) {
            minHeap.add(row);
        }
        int[][] result = new int[k][2];
        for(int i = 0; i < k; i++){
            int value[] = minHeap.poll();
            result[i][0] = value[0];
            result[i][1] = value[1];
        }
        return result;
    }

    private double distance(int x, int y) {
        return Math.sqrt(x*x + y*y);
    }
}
