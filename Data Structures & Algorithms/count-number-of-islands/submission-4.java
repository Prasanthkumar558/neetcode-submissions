class Solution {
    public int numIslands(char[][] grid) {

        int islands = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {

                if(grid[i][j] == '1') {
                    if(!visited[i][j]) {
                        dfs(grid,i,j,rows,cols,visited);
                        islands++;
                    }
                }
            }
        }

        return islands;
    }

    private void dfs(char[][] grid,int row, int col, int rows, int cols, boolean[][] visited){

        if(row < 0 || col < 0 || row >= rows || col >= cols || visited[row][col] ||
             grid[row][col] == '0') return;

        visited[row][col] = true;

        dfs(grid,row-1,col,rows,cols,visited);
        dfs(grid,row+1,col,rows,cols,visited);
        dfs(grid,row,col-1,rows,cols,visited);
        dfs(grid,row,col+1,rows,cols,visited);

    }
}
