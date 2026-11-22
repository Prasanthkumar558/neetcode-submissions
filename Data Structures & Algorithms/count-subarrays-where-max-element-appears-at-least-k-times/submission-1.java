class Solution {
    public long countSubarrays(int[] nums, int k) {

        long count = 0;
        int maxElement = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++){
            maxElement = Math.max(maxElement,nums[i]);
        }
        
        int left = 0;
        int frequency = 0;

        for(int right = 0; right<nums.length; right++){

            if(nums[right] == maxElement){
                frequency++;
            }

            while(frequency >= k){
                if(nums[left] == maxElement){
                    frequency--;
                }

                left++;
            }

            count += left;
        }

        return count;
    }
}
