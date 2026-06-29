class Solution {
    public int combinationSum4(int[] nums, int target) {

        int[] dp = new int[target+1];

        dp[0] = 1;

        for(int i=1; i<=target; i++) {

            for(int n=0; n<nums.length; n++) {

                if(i-nums[n] >=0 ){
                    dp[i] += dp[i-nums[n]];
                }
            }
        }
        return dp[target];        
    }
}