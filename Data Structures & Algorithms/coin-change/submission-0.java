class Solution {
    public int coinChange(int[] coins, int amount) {

        int n = coins.length;
        int[][] dp = new int[n][amount+1];  

        for(int w=0; w<=amount; w++) {
            if(w % coins[0] == 0) dp[0][w] = w / coins[0];
            else dp[0][w] = (int) 1e9;
        }

        for(int i=1; i<n; i++) {

            for(int w=0; w<=amount; w++) {

                int notTake = 0 + dp[i-1][w];
                int take = (int) 1e9;
                if(coins[i] <= w) take = 1 + dp[i][w-coins[i]];

                dp[i][w] = Math.min(notTake,take);
            }
        }

        int ans = dp[n-1][amount];
        if(ans >= 1e9) return -1;
        return ans;        
    }
}
