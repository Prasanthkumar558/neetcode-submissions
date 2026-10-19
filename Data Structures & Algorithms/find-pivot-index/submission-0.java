class Solution {
    public int pivotIndex(int[] nums) {
        
        for(int i=0; i<nums.length; i++) {

            int leftSum = getLeftSum(nums,i);
            int rightSum = getRightSum(nums,i);

            if(leftSum == rightSum) return i;
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