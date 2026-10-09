class Solution {
    
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {

        char[][] board = new char[n][n];

        for(int i=0; i<n; i++){
            Arrays.fill(board[i],'.');
        }

        backTrack(board,0,n);
        return ans;

    }

    private void backTrack(char[][] board,int row,int n) {

        if(row == n){
            List<String> temp = new ArrayList<>();
            for(int i=0; i<n; i++) {
                String str = new String(board[i]);
                temp.add(str);
            }
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int col=0; col<n; col++) {

            if(isSafe(row,col,board,n)) {
                board[row][col] = 'Q';
                backTrack(board,row+1,n);
                board[row][col] = '.';
            }
        }
    }

    private boolean isSafe(int row,int col,char[][] board,int n) {

        for(int i=0; i<n; i++) {
            if(board[row][i] =='Q') return false;
            if(board[i][col] == 'Q') return false;
        }

        for(int i=row,j=col; i>=0 && j>=0 ; i--,j--) {
            if(board[i][j] =='Q') return false;
        }

        for(int i=row,j=col; i>=0 && j<n; i--,j++) {
            if(board[i][j] == 'Q') return false;
        }

        return true;
    }
   
}
