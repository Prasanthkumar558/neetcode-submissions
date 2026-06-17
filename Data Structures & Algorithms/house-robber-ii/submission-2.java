class Solution {
    
    public int solve(int[] nums) {

        int n = nums.length;
        int[] dp = new int[n];

        dp[0] = nums[0];

        for(int i=1; i<n; i++) {
            
            int rob = nums[i];

            if(i > 1) rob += dp[i-2];

            int notRob = 0 + dp[i-1];

            dp[i] = Math.max(rob,notRob); 

        }

        return dp[n-1];
    }

    public int rob(int[] nums) {

        if(nums.length ==1) return nums[0];
        
        int[] nums1 = new int[nums.length-1];
        int[] nums2 = new int[nums.length-1];

        int n1i = 0;
        int n2i = 0;

        for(int i=0; i<nums.length; i++) {
            
            if(i!=0) nums1[n1i++] = nums[i];
            if(i!=nums.length-1) nums2[n2i++] = nums[i];
        }    

        return Math.max(solve(nums1),solve(nums2));
    }
}
