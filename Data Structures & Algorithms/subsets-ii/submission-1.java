class Solution {
    
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        Arrays.sort(nums);

        backTrack(nums,0,temp);

        return ans;
    }

    private void backTrack(int[] nums,int idx, List<Integer> temp) {

        ans.add(new ArrayList<>(temp));

        for(int i=idx; i<nums.length; i++) {

            if(i > idx && nums[i-1] == nums[i]) continue;

            temp.add(nums[i]);
            backTrack(nums,i+1,temp);

            temp.remove(temp.size()-1);
        }
    }

    
}
