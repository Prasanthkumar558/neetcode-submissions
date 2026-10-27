class CustomNode {
    int r;
    int c;
    int t;

    CustomNode(int r,int c,int t) {
        this.r = r;
        this.c = c;
        this.t = t;
    }
}
class Solution {

    
    public int orangesRotting(int[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<CustomNode> q = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];
        int[][] directions = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};

        for(int i=0; i<rows; i++) {

            for(int j=0; j<cols; j++) {
                if(grid[i][j] == 2) {
                    q.add(new CustomNode(i,j,0));
                }
            }
        }

        int time = 0;

        while(!q.isEmpty()) {

            CustomNode node = q.poll();
            time = Math.max(node.t,time);

            for(int[] direction : directions) {

                int nextRow = node.r + direction[0];
                int nextCol = node.c + direction[1];

                if(isValid(grid,nextRow,nextCol,visited,rows,cols)) {
                    visited[nextRow][nextCol] = true;
                    q.add(new CustomNode(nextRow,nextCol,node.t + 1));
                }
            }
        }

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {

                if(grid[i][j] == 1 && visited[i][j] == false){
                    return -1;
                }
            }
        }

        return time;
    }

    private boolean isValid(int[][] grid, int row, int col,
     boolean[][] visited, int rows, int cols) {

        return (row < rows && col < cols && row>=0 && col >=0 
           && grid[row][col] ==1 && !visited[row][col]);
    }
}
