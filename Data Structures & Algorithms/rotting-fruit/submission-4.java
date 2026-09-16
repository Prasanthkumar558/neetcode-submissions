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

        Queue<CustomNode> q = new LinkedList();
        boolean[][] visited = new boolean[rows][cols];

        int[][] directions = new int[][]{{1,0},{-1,0} ,{0,1},{0,-1}};

        for(int i=0; i<rows; i++) {

            for(int j=0; j<cols; j++) {
                if(grid[i][j] == 2) {
                    q.add(new CustomNode(i,j,0));
                }
            }
        }
        int ans = 0;
        while(!q.isEmpty()) {

            CustomNode node = q.poll();
            ans = Math.max(ans,node.t);

            for(int[] neighbour : directions) {

                int nextRow = node.r + neighbour[0];
                int nextCol = node.c + neighbour[1];

                if(isValid(nextRow,nextCol,grid,visited,rows,cols)) {
                    visited[nextRow][nextCol] = true;
                    q.add(new CustomNode(nextRow,nextCol,node.t+1));
                }
            } 


        } 

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(!visited[i][j] && grid[i][j]==1) {
                    return -1;
                }
            }
        } 
        return ans;
    }
    private boolean isValid(int row,int col,int[][] grid,boolean[][] visited,int rows,int cols) {

        return (row < rows && col < cols && row>=0 && col >=0 
           && grid[row][col] ==1 && !visited[row][col]);
        
    }
}
