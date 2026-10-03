class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        
      int totalSum = getTotalSum(nums);
      int minSum = getMinSum(nums);
      int maxSum = getMaxSum(nums);

      int circularSum = totalSum - minSum;
      
      if(maxSum < 0) return maxSum;

      return Math.max(maxSum,circularSum);
    }

    private int getTotalSum(int[] nums) {
        int sum = 0;

        for(int num : nums) {
            sum += num;
        }

        return sum;
    }

    private int getMinSum(int[] nums) {
        int ans = Integer.MAX_VALUE;
        int currentSum = 0;

        for(int num : nums) {
            currentSum += num;
            ans = Math.min(ans,currentSum);
            if(currentSum > 0) currentSum = 0;
        }

        return ans;
    }

    private int getMaxSum(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int currentSum = 0;

        for(int num : nums) {
            currentSum += num;
            ans = Math.max(ans,currentSum);
            if(currentSum < 0) currentSum = 0;
        }

        return ans;
    }
}