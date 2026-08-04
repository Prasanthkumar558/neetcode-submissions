class Solution {
    Set<List<Integer>> set = new HashSet<>();

    public List<List<Integer>> permuteUnique(int[] nums) {

        getPermutations(nums,0);

        return new ArrayList<>(set);    
    }

    private void getPermutations(int[] nums, int idx) {

        if(idx == nums.length) {
            List<Integer> list = new ArrayList<>();

            for(int num : nums) {
                list.add(num);
            }

            set.add(list);
        }
        
        for(int i=idx; i<nums.length; i++) {

            int temp = nums[i];
            nums[i] = nums[idx];
            nums[idx] = temp;

            getPermutations(nums,idx+1);

            int temp2 = nums[i];
            nums[i] = nums[idx];
            nums[idx] = temp2;
        }
    }
}