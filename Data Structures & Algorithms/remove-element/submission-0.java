class Solution {
    public int removeElement(int[] nums, int val) {
        
        int indx = -1;

        for(int i=0 ;i<nums.length; i++) {

            if(nums[i] != val) {
                indx++;
                int temp = nums[i];
                nums[indx] = nums[i];
                nums[i] = temp;
            }
        }
        return indx+1;
    }
}