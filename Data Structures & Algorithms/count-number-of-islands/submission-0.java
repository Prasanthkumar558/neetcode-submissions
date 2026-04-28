class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == '1'){
                    if(vis[i][j] == false){
                    dfs(i,j,n,m,vis,grid);
                    ans++;
                    }
                }
            }
        }
        return ans;
        
    }

    void dfs(int i,int j,int n,int m,boolean[][] vis,char[][] grid){
        if(i <0 || j< 0 || i >=n || j>= m || vis[i][j] || grid[i][j] == '0'){
            return;
        }
        vis[i][j]=true;
        dfs(i-1,j,n,m,vis,grid);
        dfs(i+1,j,n,m,vis,grid);
        dfs(i,j+1,n,m,vis,grid);
        dfs(i,j-1,n,m,vis,grid);
    }
}
