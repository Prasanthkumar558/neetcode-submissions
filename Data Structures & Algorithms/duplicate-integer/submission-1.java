class Solution {
    boolean hasDuplicate(int[] nums) {
        HashSet<Integer> s = new HashSet<>();
        boolean flag = false;
        for(int i=0;i<nums.length;i++){
            s.add(nums[i]);
        }
        if(s.size()==nums.length){
            return false;
        }
        else{
            return true;
        }
    }
};