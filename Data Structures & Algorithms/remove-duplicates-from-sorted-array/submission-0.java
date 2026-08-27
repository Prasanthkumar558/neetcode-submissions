class Solution {
    public int removeDuplicates(int[] nums) {
        
        int i=0;

        for(int j=1; j<nums.length; j++) {

            if(nums[i] != nums[j]) {
                i++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        return i+1;
    }
}