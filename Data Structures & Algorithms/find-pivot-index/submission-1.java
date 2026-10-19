class Solution {
    public int pivotIndex(int[] nums) {

        int totalSum = 0;
        int leftSum = 0;

        for(int i=0; i<nums.length; i++) {
            totalSum += nums[i];
        }

        for(int i=0; i<nums.length; i++) {
            
            int rightSum = totalSum - leftSum - nums[i];
            if(leftSum == rightSum) return i;

            leftSum += nums[i];

        }

        return -1;
    }

    private int getLeftSum(int[] nums, int startIndex) {

        int sum = 0;

        for(int i=0; i<startIndex; i++) {
            sum += nums[i];
        }

        return sum;
    }

    private int getRightSum(int[] nums, int startIndex) {

        int sum = 0;

        for(int i=startIndex+1; i<nums.length; i++) {
            sum += nums[i];
        }

        return sum;
    }
}