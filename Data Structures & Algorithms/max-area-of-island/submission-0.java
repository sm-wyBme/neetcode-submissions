class Solution {

    int[][] visited = new int[100][100];
    int largestIsland = 0;
    public int maxAreaOfIsland(int[][] grid) {

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1 && visited[i][j] == 0)
                    largestIsland = Math.max(largestIsland, dfs(i, j, grid));
            }
        }

        return largestIsland;
    }

    private int dfs(int i, int j, int[][] grid) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || visited[i][j] != 0) {
            return 0;
        }
        visited[i][j] = 1;
        return 1 + dfs(i - 1, j, grid) + dfs(i + 1, j, grid) + dfs(i, j-1, grid) + dfs(i, j+1, grid);
    }
}
