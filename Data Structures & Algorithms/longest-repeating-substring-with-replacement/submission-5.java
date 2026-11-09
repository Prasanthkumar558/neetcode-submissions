class Solution {
    public int characterReplacement(String s, int k) {

        int left = 0;
        int right = 0;
        int longest = 0;

        int[] frequency = new int[26];
        int mostFrequency = 0;

        while(right < s.length()) {

            char ch = s.charAt(right);

            frequency[ch-'A']++;

            mostFrequency = Math.max(
                mostFrequency,
                frequency[ch-'A']
            );

            int windowSize = right - left + 1;

            if(windowSize - mostFrequency > k) {
                frequency[s.charAt(left)-'A']--;
                left++;
            }

            longest = Math.max(longest, right-left+1);

            right++;
        }

        return longest;
    }
}