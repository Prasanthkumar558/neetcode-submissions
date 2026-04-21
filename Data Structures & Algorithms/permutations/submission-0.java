class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        getAllPermutations(nums,0);    
        return ans;
    }
    
    public void getAllPermutations(int[] nums,int index){
        if(index == nums.length){
            List<Integer> temp= new ArrayList<>();
            for(int num : nums){
                temp.add(num);
            }
            ans.add(new ArrayList<>(temp));
        }

        for(int i=index;i<nums.length;i++){
            int t= nums[i];
            nums[i]=nums[index];
            nums[index] = t;
            getAllPermutations(nums,index + 1);
            int t1 = nums[i];
            nums[i]=nums[index];
            nums[index]=t1;
        }
    }
}
