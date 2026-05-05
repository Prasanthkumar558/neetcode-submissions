class Solution {
    public void solve(char[][] board) {

        int rows = board.length;
        int cols = board[0].length;

        boolean[][] visited = new boolean[rows][cols];

        for(int i=0;i<cols;i++){
            
            if( !visited[0][i] && board[0][i]=='O'){
                dfs(0,i,rows,cols,visited,board);
            }

            if( !visited[rows-1][i] && board[rows-1][i] =='O'){
                dfs(rows-1,i,rows,cols,visited,board);
            }
        }

        for(int i=0;i<rows;i++){
            if( !visited[i][0] && board[i][0]=='O'){
                dfs(i,0,rows,cols,visited,board);
            }

            if( !visited[i][cols-1] && board[i][cols-1]=='O'){
                dfs(i,cols-1,rows,cols,visited,board);
            }
        }

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(!visited[i][j] && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
        
    }

    private void dfs(int row,int col,int rows,int cols,boolean[][] visited,char[][] board){

        if(row<0 || col < 0 || row>=rows || col>=cols || visited[row][col] ||
           board[row][col] != 'O') {
            return;
           }

        visited[row][col] = true;

        int[][] neighbours = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

        for(int[] neighbour : neighbours){
            int nextRow = row + neighbour[0];
            int nextCol = col + neighbour[1];

            dfs(nextRow,nextCol,rows,cols,visited,board);
        }
    }
}
