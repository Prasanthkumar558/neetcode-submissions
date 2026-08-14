class NumMatrix {

    int[][] rangeSum;

    public NumMatrix(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        rangeSum = new int[rows][cols];

        for(int i=0; i<rows; i++) {

            for(int j=0; j<cols; j++) {

                rangeSum[i][j] = matrix[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        
        int sum = 0;

        for(int i=row1; i<=row2; i++) {
            
            for(int j=col1; j<=col2; j++) {

                sum += rangeSum[i][j];
            }
        }

        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */