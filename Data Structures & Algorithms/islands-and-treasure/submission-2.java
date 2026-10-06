class Node{
    int row,col,distance;
    Node(int r,int c,int d){
        row = r;
        col = c;
        distance = d;
    }
}
class Solution {
    private boolean isValid(int row,int col,int rows,int cols){
        
        return (row>=0 && row<rows && col>=0 && col<cols);
    }
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] distances = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};

        Queue<Node> q = new LinkedList<>();

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j] == 0){
                    q.add(new Node(i,j,0));
                }
            }
        }

        while(!q.isEmpty()){
            Node currNode = q.poll();

            for(int [] dist : distances){
                int nextRow = currNode.row + dist[0];
                int nextCol = currNode.col + dist[1];

                if(isValid(nextRow,nextCol,rows,cols) &&
                 grid[nextRow][nextCol]==Integer.MAX_VALUE){
                    
                    grid[nextRow][nextCol] = currNode.distance+1;
                    q.add(new Node(nextRow,nextCol,grid[nextRow][nextCol]));

                }
            }
        }
    }
}
