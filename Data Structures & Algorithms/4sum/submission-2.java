class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++) {
            
            if(i > 0 && nums[i] == nums[i-1]) continue;

            for(int j=i+1; j<nums.length; ) {
                
                
                int k = j+1;
                int l = nums.length-1;

                while( k < l) {
                    
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];

                    if(sum > target) {
                        l--;
                    }
                    else if(sum < target) {
                        k++;
                    }
                    else{
                  List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                        ans.add(list);
                       
                    
                        k++;
                        l--;

                        while( k < l && nums[k] == nums[k-1]) k++;

                    }

                }

                j++;
                while(j < nums.length && nums[j] == nums[j-1]) j++;
            }
        }

        return ans;
    }
}