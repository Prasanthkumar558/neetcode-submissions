class Solution {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        
        backTrack(nums,0,temp);

        return ans;
    }

    private void backTrack(int[] nums,int idx,List<Integer> temp) {

        ans.add(new ArrayList<>(temp));

        for(int i=idx; i<nums.length; i++) {

            temp.add(nums[i]);
            backTrack(nums,i+1,temp);

            temp.remove(temp.size()-1);
        }
    }


}
