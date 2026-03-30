class Solution {
    public int search(int[] nums, int target) {
        int ans = -1;

        int start = 0;
        int end = nums.length - 1;

        while(start <= end){

            int mid = start + (end - start)/2;
            if(nums[mid]==target){
                ans = mid;
                break;
            }
            if(nums[start] <= nums[mid]){   // left array is sorted
                
                if(nums[start] <= target && target <= nums[mid]){
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }
            else{          // right array is sorted
                if(nums[mid] <= target && target <= nums[end]){
                    start = mid + 1;
                }
                else{
                    end = mid - 1;
                }
            }
        }
        return ans;
    }
}
