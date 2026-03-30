class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] sol = new int[nums.length];

        int[] prefixSum = new int[nums.length];
        prefixSum[0]=1;

        for(int i=1;i<nums.length;i++){
            prefixSum[i] = prefixSum[i-1] * nums[i-1];
        }

        int[] suffixSum = new int[nums.length];
         
        suffixSum[nums.length-1]=1;

        for(int i=nums.length-2;i>=0;i--){
            suffixSum[i] = suffixSum[i+1] * nums[i+1];
        }

        for(int i=0;i<nums.length;i++){
            sol[i] = prefixSum[i] * suffixSum[i];
        }
        return sol;

    }
}  
