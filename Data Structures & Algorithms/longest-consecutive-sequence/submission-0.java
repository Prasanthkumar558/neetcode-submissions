class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int longSequence=0;
        for(Integer element : set){
            int e = element-1;
            if(set.contains(e)) continue;
            else{
                int current = element;
                int count=0;
                while(set.contains(current)){
                    count++;
                    current++;
                }
                longSequence = Math.max(count,longSequence);
            }

        }
        return longSequence;
    }
}
