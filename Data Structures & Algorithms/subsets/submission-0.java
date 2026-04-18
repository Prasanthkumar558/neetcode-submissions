class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        getAllSubsets(nums,0);
        return ans;
    }

    public void getAllSubsets(int[ ] nums, int index){
        if(index == nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }

        // include number
        temp.add(nums[index]);
        
        getAllSubsets(nums,index+1);

        // exclude number
        temp.remove(temp.size() -1);
        
        getAllSubsets(nums,index+1);
    }
}
