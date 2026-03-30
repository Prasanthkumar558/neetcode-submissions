class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        int[] ans = new int[nums.length-k+1];
        int arrIdx = 0;
        
        for(int i=0;i<nums.length;i++){

            while(!dq.isEmpty() && nums[dq.getLast()] < nums[i]){
                dq.removeLast();
            }
            dq.addLast(i);

            while(dq.size() > 0 && dq.getFirst() <= i - k ){
                dq.removeFirst();
            }

            if(i >=k-1){
                ans[arrIdx++] = nums[dq.getFirst()];
            }

        }

        return ans;
    }
}
