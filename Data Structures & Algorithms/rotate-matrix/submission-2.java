class Solution {
    public void rotate(int[][] matrix) {
    
        // int[][] ans = new int[matrix.length][matrix[0].length];

        // for(int i=0; i<matrix.length; i++){
            
        //     for(int j=0; j<matrix[0].length; j++){
        //         ans[j][matrix[0].length - 1 -i] = matrix[i][j];
        //     }
        // }

        // for(int i=0; i<matrix.length; i++){

        //     for(int j=0; j<matrix[0].length; j++){
        //         matrix[i][j] = ans[i][j];
        //     }
        // }

        int n = matrix.length;

        // Transpose a matrix;

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse every row

        for(int i=0; i<n; i++){
            
            reverse(matrix[i]);
        }
    }

    private void reverse(int[] row) {

        int start = 0;
        int end = row.length - 1;

        while(start < end) {
            int temp = row[start];
            row[start] = row[end];
            row[end] = temp;
            start++;
            end--;
        }
    }
}
