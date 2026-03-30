class Solution {
    public int search(int[] nums, int target) {
        
        int ans = -1;
        int low  = 0;
        int high = nums.length-1;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            
            if(nums[mid]==target){
                ans = mid;
                break;
            }
            else if(nums[mid]>target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
}
