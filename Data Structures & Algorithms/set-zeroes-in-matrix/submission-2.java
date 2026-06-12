class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] check = new boolean[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++) {
                if(matrix[i][j] == 0) {
                    check[i][j] = true;
                }
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                
                if(matrix[i][j] == 0 && check[i][j] == true) {
                    
                    mark(i,j,matrix);
                }
            }
        }
    }
    private void mark(int row,int col,int[][] matrix) {

        for(int i=0; i<matrix[0].length; i++) {
            matrix[row][i] = 0;
        }

        for(int i=0; i<matrix.length; i++) {
            matrix[i][col] = 0;
        }
    } 
}
