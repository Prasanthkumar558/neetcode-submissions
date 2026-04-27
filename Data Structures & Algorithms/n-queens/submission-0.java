class Solution {
   private List<List<String>> ans = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];

        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }

        solve(0,board,n);

        return ans;
    }

    private void solve(int row,char[][] board,int n){
        
        if(row==n){
            List<String> temp = new ArrayList<>();

            for(int i=0;i<n;i++){
                char[] ch = board[i];
                temp.add(new String(ch));
                
            }
            ans.add(temp);
            return;
        }

        for(int col= 0;col <n;col++){

            if(isSafe(row,col,board,n)){
                board[row][col] = 'Q';
                solve(row+1,board,n);
                board[row][col]='.';
            }
        }
    }

    private boolean isSafe(int row,int col,char[][] board,int n){

        for(int i=0;i<n;i++){
            if(board[row][i] == 'Q') return false;
        }

        for(int i=0;i<n;i++){
            if(board[i][col] == 'Q') return false;
        }

        for(int i=row,j=col;i>=0&&j>=0;i--,j--){
            if(board[i][j] =='Q') return false;
        }

        for(int i=row,j=col;i>=0 && j<n;i--,j++){
            if(board[i][j] == 'Q')return false;
        }

        return true;
    }
}
