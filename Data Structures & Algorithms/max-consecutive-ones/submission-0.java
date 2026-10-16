class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        
        int maxOnes = 0;
        int currentOnes = 0;

        for(int i=0; i<nums.length; i++) {
            
            if(nums[i] != 1) {
                maxOnes = Math.max(maxOnes,currentOnes);
                currentOnes = 0;
            }
            else{
                currentOnes++;
            }
        }

        maxOnes = Math.max(maxOnes,currentOnes);
        return maxOnes;
    }
}