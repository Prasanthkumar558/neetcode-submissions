class Solution {
    private int totalSum = 0;

    public int subsetXORSum(int[] nums) {

        backTrack(nums,0,0); 

        return totalSum;   
    }

    private void backTrack(int[] nums,int i,int xorTotal) {

        if(i == nums.length) {
            totalSum += xorTotal;
            return;
        }

        // pick
        backTrack(nums, i+1, xorTotal ^ nums[i]);

        // not pick
        backTrack(nums, i+1, xorTotal);
    }
}