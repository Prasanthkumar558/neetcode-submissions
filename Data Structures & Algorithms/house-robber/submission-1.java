class Solution {
    public int rob(int[] nums) {

        int[] dp = new int[nums.length];

        dp[0] = nums[0];

        for(int i=1; i<nums.length; i++){

            int rob = nums[i];
            if(i > 1) {
                rob += dp[i-2];
            }

            int notRob = 0 + dp[i-1];

            dp[i] = Math.max(rob,notRob);
        }   

        return dp[nums.length-1];
    }
}
