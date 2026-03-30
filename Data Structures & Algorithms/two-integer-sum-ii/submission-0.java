class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = {-1,-1};
        if(numbers.length<2){
            return ans;
        }
        int st = 0;
        int end = numbers.length-1;
        while(st<end){
            int sum = numbers[st]+numbers[end];
            if(sum==target){
                ans[0]=st+1;
                ans[1]=end+1;
                break;
            }
            if(sum>target){
                end--;
            }
            if(sum<target){
                st++;
            }
            
        }
        return ans;
    }
}
