class Solution {
    public int maxAreaOfIsland(int[][] grid) {

        int ans = 0;

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    if(vis[i][j] == false){
                        int area = dfs(i,j,n,m,vis,grid);
                        ans = Math.max(ans,area);
                    }
                }
            }
        }
        return ans;
        
    }

    int dfs(int row,int col,int n,int m,boolean[][] vis,int[][] grid){
        if(row < 0 || col < 0 || row>=n || col>=m || vis[row][col] || grid[row][col]==0){
            return 0;
        }

        vis[row][col] = true;
        int ans = 1;
        ans += dfs(row+1,col,n,m,vis,grid);
        ans += dfs(row-1,col,n,m,vis,grid);
        ans += dfs(row,col+1,n,m,vis,grid);
        ans += dfs(row,col-1,n,m,vis,grid);

        return ans;
    }
}
