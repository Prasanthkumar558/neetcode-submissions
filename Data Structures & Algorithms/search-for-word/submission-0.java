class Solution {
    public boolean exist(char[][] board, String word) {

        for(int r=0;r<board.length;r++){
            for(int c=0;c<board[0].length;c++){
                if(word.charAt(0) == board[r][c]){
                    if(test(board,r,c,0,word)) return true;
                }
            }
        }
        return false;
    }

    public boolean test(char[][] board,int r,int c,int index,String word){
        if(index == word.length()){
            return true;
        }

        int row = board.length;
        int col = board[0].length;

        if(r<0 || c<0 || r>=row || c>=col){
            return false;
        }

        if(board[r][c] == ' ' || board[r][c] != word.charAt(index)){
            return false;
        }

        char ch = board[r][c];
        board[r][c]=' ';

        if( test(board,r-1,c,index+1,word) || test(board,r+1,c,index+1,word) || 
            test(board,r,c-1,index+1,word) || test(board,r,c+1,index+1,word)){
                return true;
            }

        board[r][c] = ch;
        return false;
    }
}
