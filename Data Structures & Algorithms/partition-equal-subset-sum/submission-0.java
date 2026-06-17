class Solution {

    public boolean subSetSumOfTarget(int[] nums,int k) {

        int n = nums.length;

        boolean[][] dp = new boolean[n][k+1];

        for(int i=0; i<n; i++) {
            dp[i][0] = true;
        }

        dp[0][nums[0]] = true;

        for(int i=1; i<n; i++) {

            for(int target=1; target<=k; target++) {

                boolean noTake = dp[i-1][target];
                boolean take = false;

                if(nums[i] <= target) take = dp[i-1][target-nums[i]];

                dp[i][target] = take || noTake;
                
            }
        }

        return dp[n-1][k];
    }

    public boolean canPartition(int[] nums) {

        int totalSum = Arrays.stream(nums).boxed().reduce(0, (a,b) -> a+b);

        if( totalSum % 2 != 0) return false;
        int k = totalSum / 2;

        return subSetSumOfTarget(nums,k);
    }
}
