class CustomNode{
    int row,col,time;
    CustomNode(int r,int c,int t){
        row = r;
        col = c;
        time = t;
    }
}
class Solution {

    private boolean isValid(int row,int col,int rows,int cols,boolean[][] vis,int[][] grid){

        return (row>=0 && row<rows && col>=0 && col<cols && !vis[row][col] && 
                grid[row][col]==1);
    }
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int ans=0;

        boolean[][] visited = new boolean[rows][cols];
        int[][] neighbours = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};

        Queue<CustomNode> q = new LinkedList<>();

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==2){
                    q.add(new CustomNode(i,j,0));
                }
            }
        }

        while(!q.isEmpty()){
            CustomNode node = q.poll();
            ans = Math.max(ans,node.time);

            for(int[] neighbour : neighbours){
                int nextRow = node.row + neighbour[0];
                int nextCol = node.col + neighbour[1];

                if(isValid(nextRow,nextCol,rows,cols,visited,grid)){
                    visited[nextRow][nextCol] = true;
                    q.add(new CustomNode(nextRow,nextCol,node.time+1));
                }
            }
        }

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    return -1;
                }
            }
        }

        return ans;
    }
}
