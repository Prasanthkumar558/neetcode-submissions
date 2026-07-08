class Solution {
    public void sortColors(int[] nums) {
        int red = 0;
        int blue = nums.length-1;
        int white = 0;
        while(white<=blue) {
            if(nums[white] == 0) {
                int temp = nums[red];
                nums[red] = nums[white];
                nums[white] = temp;
                red++;
                white++;
            }
            else if(nums[white] == 2) {
                int temp = nums[blue];
                nums[blue] = nums[white];
                nums[white] = temp;
                blue--;
            }
            else{
                white++;
            }
        }
        
    }
}