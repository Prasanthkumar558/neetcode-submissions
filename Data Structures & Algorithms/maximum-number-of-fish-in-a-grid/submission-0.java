class Solution {
    public int findMaxFish(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;
        int ans = 0;
        boolean[][] visited = new boolean[rows][cols];

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){

                if(grid[i][j] != 0){
                    int fishes = collectAllFishes(grid,i,j,rows,cols,visited);
                    ans = Math.max(ans,fishes);
                }
            }
        }

        return ans;
    }

    private int collectAllFishes(int[][] grid, int row, int col, int rows, int cols, boolean[][] visited){

        if(row < 0 || col < 0 || row >= rows || col >= cols || grid[row][col] == 0 || visited[row][col]){
            return 0;
        }

        visited[row][col] = true;
        int fishes = grid[row][col];
        int collectingFishes = fishes;
        collectingFishes += collectAllFishes(grid,row-1,col,rows,cols,visited);
        collectingFishes += collectAllFishes(grid,row+1,col,rows,cols,visited);
        collectingFishes += collectAllFishes(grid,row,col-1,rows,cols,visited);
        collectingFishes += collectAllFishes(grid,row,col+1,rows,cols,visited);

        grid[row][col] = fishes;

        return collectingFishes;
    }
}
