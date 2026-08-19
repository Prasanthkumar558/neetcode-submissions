class Solution {
    public int searchInsert(int[] nums, int target) {
        
        int left = 0;
        int right = nums.length-1;
        int ans = -1;

        while( left <= right) {

            int mid = left + ( right - left ) / 2;

            if(nums[mid] == target) return mid;
            else if(nums[mid] >= target) {
                ans = mid;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }

        if(ans == -1) return nums.length;
        
        return ans;
    }
}