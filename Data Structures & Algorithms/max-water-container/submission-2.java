class Solution {
    public int maxArea(int[] heights) {
        int ans = 0;

        if(heights.length < 2){
            return ans;
        }

        int left = 0;
        int right = heights.length -1;

        while(left < right) {

            int width = right - left;
            int minValue = Math.min(heights[right],heights[left]);
            int area = width * minValue;
            ans = Math.max(ans,area);

            if(heights[left] < heights[right]) {
                left++;
            }
            else {
                right--;
            }
        }
        return ans;
    }
}
