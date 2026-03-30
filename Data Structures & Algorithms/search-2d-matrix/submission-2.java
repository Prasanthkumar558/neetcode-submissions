class Solution {

    public boolean isPresent(int[][] matrix , int target, int row){
        int col = matrix[0].length;
        int st = 0;
        int end = col - 1;
        while(st<=end){
            int mid = st + (end - st)/2;
            if(matrix[row][mid] == target){
                return true;
            }
            else if(matrix[row][mid] < target){
                st = mid + 1;
            }
            else{
                end = mid - 1;
            }

        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int col = matrix[0].length;
        int start = 0;
        int end = rows - 1;
        int n = col -1;
        boolean ans = false;

        while(start <= end){
            int midRow = start + (end - start)/2;

            if(matrix[midRow][0] <= target && matrix[midRow][n] >= target){
                if(isPresent(matrix , target , midRow)){
                    ans = true;
                }
                else{
                    ans = false;
                }
                break;
            }
            else if(target > matrix[midRow][n]){
                start = midRow + 1;
            }
            else{
                end = midRow - 1;
            }
        }
        return ans;

    }
}
