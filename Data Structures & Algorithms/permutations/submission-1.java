class Solution {
  
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

        backTrack(nums,0);

        return ans;        
    }

    private void backTrack(int[] nums,int idx) {

        if(idx == nums.length) {

            List<Integer> temp = new ArrayList<>();
            for(int ele : nums) temp.add(ele);

            ans.add(new ArrayList<>(temp));
            return;
        } 

        for(int i=idx; i<nums.length; i++) {

            int temp = nums[i];
            nums[i] = nums[idx];
            nums[idx] = temp;

            backTrack(nums,idx+1);

            int temp1 = nums[i];
            nums[i] = nums[idx];
            nums[idx] = temp1;
        }
    }
    
}
