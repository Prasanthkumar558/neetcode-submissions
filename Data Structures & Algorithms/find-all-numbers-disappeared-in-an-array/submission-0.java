class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        HashSet<Integer> set = new HashSet<>();

        for(int num : nums){
            set.add(num);
        }

        List<Integer> ans = new ArrayList<>();

        int count = 1;
        while(count <= nums.length){
            if(!set.contains(count)){
                ans.add(count);
            }

            count++;
        }

        return ans;
    }
}