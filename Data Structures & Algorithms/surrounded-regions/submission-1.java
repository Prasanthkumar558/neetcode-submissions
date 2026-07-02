class Solution {
    public void solve(char[][] board) {

        int rows = board.length;
        int cols = board[0].length;

        boolean[][] visited = new boolean[rows][cols];

        for(int i=0; i<rows; i++) {

            if(!visited[i][0] && board[i][0]=='O') {
                dfs(i,0,rows,cols,board,visited);
            }

            if(!visited[i][cols-1] && board[i][cols-1] =='O'){
                dfs(i,cols-1,rows,cols,board,visited);
            }
        }

        for(int i=0; i<cols; i++) {

            if(!visited[0][i] && board[0][i] == 'O') {
                dfs(0,i,rows,cols,board,visited);
            }

            if(!visited[rows-1][i] && board[rows-1][i]  == 'O' ) {
                dfs(rows-1,i,rows,cols,board,visited);
            }
        }

        for(int i=0; i<rows; i++) {

            for(int j=0; j<cols; j++) {

                if(!visited[i][j] && board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }

    private void dfs(int i, int j, int rows, int cols, char[][] board, boolean[][] visited) {

        if(i < 0 || j < 0 || i >= rows || j >= cols || visited[i][j] || board[i][j] != 'O') return;

        visited[i][j] = true;

        dfs(i-1,j,rows,cols,board,visited);
        dfs(i+1,j,rows,cols,board,visited);
        dfs(i,j-1,rows,cols,board,visited);
        dfs(i,j+1,rows,cols,board,visited);
    }
}
