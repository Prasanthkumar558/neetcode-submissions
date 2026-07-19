class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        
        int totalSum = getTotalSum(nums);
        int minSum = getMinSum(nums);
        int maxSum = getMaxSum(nums);

        int circularSum = totalSum - minSum;

        if(maxSum < 0) {
            return maxSum;
        }

        return Math.max(maxSum,circularSum);

    }

    private int getTotalSum(int[] nums) {
        
        return Arrays.stream(nums)
                                .boxed()
                                .reduce(0,(a,b) -> a+b);
    }

    private int getMinSum(int[] nums) {
        int minsum = nums[0];
        int curr = 0;

        for(int i=0; i<nums.length; i++) {
            curr += nums[i];

            minsum = Math.min(minsum,curr);
            if(curr > 0) {
                curr = 0;
            }
        }
        return minsum;
    }

    private int getMaxSum(int[] nums) {
        int maxsum = nums[0];

        int curr = 0;

        for(int i=0; i<nums.length; i++) {
            curr += nums[i];

            maxsum = Math.max(curr,maxsum);

            if(curr < 0) {
                curr = 0;
            }
        }
        return maxsum;
    }
}