class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int[] sol = {-1,-1};
        if(nums.length<2){
            return sol;
        }
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int n = target-nums[i];
            if(mp.containsKey(n)){
                int j=mp.get(n);
                sol[0]=j;
                sol[1]=i;
            }
            else{
                mp.put(nums[i],i);
            }
        }
        return sol;
    }

}
