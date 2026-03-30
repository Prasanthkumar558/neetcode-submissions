class Solution {
    public int trap(int[] height) {
        int ans=0;
        int leftMax = 0;
        int rightMax = 0;
        int left = 0;
        int right = height.length-1;
        
        while(left<right){

            leftMax = Math.max(leftMax,height[left]);
            rightMax = Math.max(rightMax,height[right]);

            if(leftMax<rightMax){
                ans += leftMax - height[left];
                left++;
            }
            else{
                ans += rightMax - height[right];
                right--;
            }

        }
        return ans;
    }
}
