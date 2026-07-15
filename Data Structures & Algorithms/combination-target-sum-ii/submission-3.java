class Solution {

    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        Arrays.sort(candidates);
        backTrack(candidates,0,target,temp);

        return ans;
    }

    private void backTrack(int[] nums,int idx, int target,List<Integer> temp) {

        if(target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i=idx; i<nums.length; i++) {
            
            if(nums[i] > target) break;
            if(i> idx && nums[i-1] == nums[i]) continue;

            temp.add(nums[i]);
            backTrack(nums,i+1,target - nums[i],temp);

            temp.remove(temp.size()-1);
        }
    }


}
