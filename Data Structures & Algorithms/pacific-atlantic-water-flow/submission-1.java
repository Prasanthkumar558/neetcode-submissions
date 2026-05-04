class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        for(int i=0;i<rows;i++){
            dfs(i,0,pacific,-1,-1,heights);
            dfs(i,cols-1,atlantic,-1,-1,heights);
        }

        for(int i=0;i<cols;i++){
            dfs(0,i,pacific,-1,-1,heights);
            dfs(rows-1,i,atlantic,-1,-1,heights);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);

                    ans.add(new ArrayList<>(temp));
                }
            }
        }
        return ans;
        
    }

    private void dfs(int i,int j,boolean[][] reach,int oi,int oj,int[][] heights){
        
        if(i < 0 || j < 0 || i>=heights.length || j>=heights[0].length || reach[i][j] ||
        (oi>=0 && oj>=0 && heights[oi][oj] > heights[i][j] )) return;

        reach[i][j] = true;

        dfs(i+1,j,reach,i,j,heights);
        dfs(i-1,j,reach,i,j,heights);
        dfs(i,j+1,reach,i,j,heights);
        dfs(i,j-1,reach,i,j,heights);
    }
}
