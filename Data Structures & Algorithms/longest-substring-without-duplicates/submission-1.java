class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] frequency = new int[256];
        for(int i=0;i<256;i++){
            frequency[i]=-1;
        } 
        int maxLength = 0;
        int left = 0;
        int right = 0;
        while(right<s.length()){
            char ch  = s.charAt(right);
            if(frequency[ch]!=-1){
                if(frequency[ch]>=left){
                    left = frequency[ch]+1;
                }

            }
            int windowLength = right - left + 1;
            maxLength = Math.max(maxLength,windowLength);
            frequency[ch]=right;
            right++;

        }
        return maxLength;
    }
}
