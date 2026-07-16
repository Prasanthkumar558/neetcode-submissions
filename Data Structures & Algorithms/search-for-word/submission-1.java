class Solution {
    public boolean exist(char[][] board, String word) {

        int rows = board.length;
        int cols = board[0].length;

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {

                if(word.charAt(0) == board[i][j]) {

                    if(backTrack(board,i,j,0,word)) return true;
                }
            }
        }
        return false;
    }

    private boolean backTrack(char[][] board,int row,int col,int idx,String word) {

        if(idx == word.length()) return true;

        int rows = board.length;
        int cols = board[0].length;

        if(row <0 || col < 0 || row >= rows || col >= cols) return false;

        if(board[row][col] == ' ' || word.charAt(idx) != board[row][col]) return false;
        
        char ch = board[row][col];

        board[row][col] = ' ';

        boolean up = backTrack(board,row-1,col,idx+1,word);
        boolean down = backTrack(board,row+1,col,idx+1,word);
        boolean right = backTrack(board,row,col+1,idx+1,word);
        boolean left = backTrack(board,row,col-1,idx+1,word);

        if(up || down || right || left) return true;

        board[row][col] = ch;
        return false;

    }
}
