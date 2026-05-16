class Solution {

    private int sumOfArray(int[] nums){
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        return sum;
    }

    private int sumOfTotal(int n){
        int ans = n * (n+1)/2;

        return ans;
    }

    public int missingNumber(int[] nums) {
        
        int arraySum = sumOfArray(nums);

        int totalSum = sumOfTotal(nums.length);

        int missingNumber = totalSum - arraySum;

        return missingNumber;
    }
}
