class Solution {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    HashSet<List<Integer>> set = new HashSet<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        
        backTrack(nums,0,target,temp);

        return ans;
    }

    public void backTrack(int[] nums,int idx,int target, List<Integer> temp) {

        if(target == 0) {
            
            if(!set.contains(new ArrayList<>(temp))) {
                ans.add(new ArrayList<>(temp));
                set.add(new ArrayList<>(temp));
            }
            return;
        }

        for(int i=idx; i<nums.length; i++) {

            if(target < nums[i]) continue;

            temp.add(nums[i]);
            backTrack(nums,i,target-nums[i],temp);

            temp.remove(temp.size()-1);
        }
        

    }

}
