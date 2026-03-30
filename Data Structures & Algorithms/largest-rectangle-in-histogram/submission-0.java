class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] right = new int[n];
        int[] left = new int[n];
        Stack<Integer> st = new Stack<>();
        int ans = 0;

        for(int i= n-1 ;i>=0; i--){

            while(st.size() > 0 && heights[i] <= heights[st.peek()]){
                st.pop();
            }
            
            right[i] = st.isEmpty() ? n : st.peek();

            st.push(i);
        }

        while(st.size() >0 ){
            st.pop();
        }

        for(int i=0;i<n;i++){
            while(st.size() > 0 && heights[i] <= heights[st.peek()]){
                st.pop();
            }

            left[i] = st.isEmpty() ? -1 : st.peek();

            st.push(i);
        }

        for(int i=0;i<n;i++){
            int width = right[i] - left[i] -1;
            int area = heights[i] * width;
            ans = Math.max(ans,area);
        }
        
        return ans;
    }
}
