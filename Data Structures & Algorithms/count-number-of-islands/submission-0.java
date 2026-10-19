class Solution {

    int[][] visited = new int[100][100];
    public int numIslands(char[][] grid) {
        int number_of_islands = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1' && visited[i][j] == 0){
                     dfs(i, j, grid);
                    number_of_islands++;
                } 
            }
        }

        return number_of_islands;
    }

    private void dfs(int i, int j, char[][] grid) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0' || visited[i][j] != 0) {
            return;
        }
        visited[i][j] = 1;
        dfs(i - 1, j, grid);
        dfs(i + 1, j, grid);
        dfs(i, j-1, grid);
        dfs(i, j+1, grid);
    }
}