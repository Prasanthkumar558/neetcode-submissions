class Solution {
    public int longestMonotonicSubarray(int[] nums) {

        if(nums.length == 1) return 1;
        
        int increasing = 1;
        int decreasing = 1;
        int ans = 0;

        for(int i=1; i<nums.length; i++){

            if(nums[i] > nums[i-1]){
                increasing = 1 + increasing;
                decreasing = 1;
            }
            else if(nums[i] < nums[i-1]){
                decreasing = 1 + decreasing;
                increasing = 1;
            }
            else{
                increasing = 1;
                decreasing = 1;
            }
            ans = Math.max(ans,Math.max(increasing,decreasing));
        }

        return ans;
    }
}