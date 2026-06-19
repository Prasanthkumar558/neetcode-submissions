class Solution {
    public int change(int amount, int[] coins) {

        int n = coins.length;

        int[][] dp = new int[n][amount+1];

        for(int w=0; w<=amount; w++) {

            if(w % coins[0] == 0) dp[0][w] = 1;
            else dp[0][w] = 0;
        }

        for(int i=1; i<n; i++) {

            for(int w=0; w<=amount; w++) {

                int notTake = dp[i-1][w];
                int take = 0;
                if(coins[i] <= w) take = dp[i][w-coins[i]];

                dp[i][w] = notTake + take;
            }
        }

        return dp[n-1][amount];
        
    }
}
