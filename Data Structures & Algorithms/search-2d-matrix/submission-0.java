class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        //first traversal in the row
        int i = 0;
        int j = m - 1;
        int rowIndex = -1;
        while(i <= j){
            int midpoint = i + (j - i)/2;
            if(matrix[midpoint][0] <= target) {
                i = midpoint + 1; // keep the range in mind
                rowIndex = midpoint;
            } else 
                j = midpoint - 1;
        }

        if(rowIndex == -1) return false;

        i = 0;
        j = n - 1;
        if(matrix[rowIndex][0] == target) return true;
        while(i <= j){
            int midpoint = i + (j - i)/2;
            if(matrix[rowIndex][midpoint] == target) return true;
            if(matrix[rowIndex][midpoint] > target) j = midpoint - 1;
            else i = midpoint + 1;
        }

        return false;
    }
}
