class Solution {
    public int characterReplacement(String s, int k) {
        
        int left = 0;
        int right = 0;
        int longest = 0;
        int[] frequency = new int[27];
        int mostFrequency = 0;

        while(right < s.length()){
            char ch = s.charAt(right);
            frequency[ch-'A']++;
            mostFrequency = Math.max(mostFrequency,frequency[ch-'A']);
            
            int windowSize = right - left + 1;
            if(windowSize - mostFrequency <= k){
                longest = Math.max(longest,windowSize);
            }

            if(windowSize - mostFrequency > k){
                char l = s.charAt(left);
                frequency[l-'A']--;
                
                mostFrequency = 0;
                for(int i=0;i<27;i++){
                    mostFrequency = Math.max(mostFrequency,frequency[i]);
                }
                left++;
                
            }
            right++;

        }
        return longest;

   }
}
