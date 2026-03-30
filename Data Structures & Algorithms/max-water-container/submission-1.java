class Solution {
    public int maxArea(int[] heights) {
        int ans=0;
        if(heights.length<2){
            return 0;
        }
        int left = 0;
        int right = heights.length-1;
        while(left<right){
            int width = right-left;
            int lowestHeight = Math.min(heights[left],heights[right]);
            int waterStorage = width * lowestHeight;
            ans = Math.max(ans,waterStorage);

            if(heights[left]<heights[right]) left++;
            else right--;
        }
        return ans;
    }
}
