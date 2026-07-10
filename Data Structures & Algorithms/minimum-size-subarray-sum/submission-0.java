class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;

        int left = 0;
        int right = 0;
        int presentSum = 0;

        while(right <nums.length) {
            
            presentSum += nums[right];

            while(presentSum >= target) {
                ans = Math.min(ans,right - left +1);
                presentSum -= nums[left];
                left++;
            }

            right++;
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}