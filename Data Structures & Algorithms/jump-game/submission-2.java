class Solution {
    public boolean canJump(int[] nums) {

        int maxIndexCanJump = 0;

        for(int i=0; i<nums.length; i++) {
            if(maxIndexCanJump < i) return false;
            maxIndexCanJump = Math.max(maxIndexCanJump,nums[i] + i);
        }

        return true;
    }
}
