class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        getAllSubSets(nums,0);

        return ans;
    }

    public void getAllSubSets(int[] nums,int index){
        ans.add(new ArrayList<>(temp));

        for(int i=index ;i<nums.length;i++){

            if(i > index && nums[i] == nums[i-1]) continue;

            temp.add(nums[i]);
            getAllSubSets(nums,i+1);

            temp.remove(temp.size()-1);
        }
    }
}
