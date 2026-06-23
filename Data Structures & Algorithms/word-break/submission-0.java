class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        int n = s.length();

        boolean[] dp = new boolean[n+1];
        
        HashSet<String> wordSet = new HashSet<>(wordDict);

        int maxLength = 0;

        for(String str : wordSet) {
            maxLength = Math.max(maxLength,str.length());
        }

        dp[0] = true;

        for(int i=1; i<=n; i++) {

            for(int j=i-1; j>=(Math.max(0,i-maxLength)); j--) {
                if(dp[j] && wordSet.contains(s.substring(j,i))){
                    dp[i] = true;
                }
            } 
        }
        return dp[n];
    }
}
