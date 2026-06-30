class Solution {
    public boolean stoneGame(int[] piles) {
        
        int n = piles.length;

        int[][] dp = new int[n][n];

        for(int i=0; i<n; i++) {

            for(int j=0; j<n; j++) {
                dp[i][j] = -1;
            }
        }

        return solve(0,n-1,piles,dp) > 0;
        
    }

    private int solve(int start,int end,int[] piles,int[][] dp) {

        if(start > end) return 0;

        if(dp[start][end] != -1) return dp[start][end];

        int leftSide = piles[start] - solve(start + 1, end,piles,dp);
        int rightSide = piles[end] - solve(start, end-1,piles,dp);

        return dp[start][end] = Math.max(leftSide,rightSide);
    }
}