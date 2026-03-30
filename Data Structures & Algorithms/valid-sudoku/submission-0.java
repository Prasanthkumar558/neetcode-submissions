class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n=9;
        Set<Character>[] rows = new HashSet[n];
        Set<Character>[] col = new HashSet[n];
        Set<Character>[] grid = new HashSet[n];

        for(int i=0;i<n;i++){
            rows[i] = new HashSet<Character>();
            col[i] = new HashSet<Character>();
            grid[i] = new HashSet<Character>();
        }

        for(int rowI=0;rowI<n;rowI++){
            for(int colJ=0;colJ<n;colJ++){
                char val = board[rowI][colJ];
                if(val=='.') continue;

                if(rows[rowI].contains(val)) return false;
                else rows[rowI].add(val);

                if(col[colJ].contains(val)) return false;
                else col[colJ].add(val);

                int gridIndex = 3 * (rowI/3) + colJ/3;
                if(grid[gridIndex].contains(val)) return false;
                else grid[gridIndex].add(val);

            }
        }
        return true;
     }
}
