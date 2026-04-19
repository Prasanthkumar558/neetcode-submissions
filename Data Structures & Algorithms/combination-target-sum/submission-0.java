class Solution {

    List<List<Integer>> ans = new ArrayList<>();
    HashSet<List<Integer>> set = new HashSet<>();
    List<Integer> temp = new ArrayList<>();
    
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        getCombinationSum(nums,target,0);
        return ans;
    }

    public void getCombinationSum(int[] nums,int target,int index){
    
        if(index == nums.length || target < 0){
            return;
        }
        if(target==0){
            List<Integer> t = new ArrayList<>(temp);
            if(!set.contains(t)){
                ans.add(t);
                set.add(t);
            }
            return;
        }

        // inclusion part single time
        temp.add(nums[index]);
        getCombinationSum(nums,target-nums[index],index+1);

        // inclusion multiple time
        getCombinationSum(nums,target-nums[index],index);

        //exclusion
        temp.remove(temp.size()-1);
        getCombinationSum(nums,target,index+1);
    }
}
