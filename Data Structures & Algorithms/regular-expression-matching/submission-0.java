class Solution {
    public boolean isMatch(String s, String p) {

        int n = s.length();
        int m = p.length();

        boolean[][] dp = new boolean[n+1][m+1];
        dp[n][m] = true;

        for(int i=m-1; i>=0; i--) {
            if(i + 1 < m && p.charAt(i+1) == '*') {
                dp[n][i] = dp[n][i+2];
            }
            else{
                dp[n][i] = false;
            }
        }

        for(int i=n-1; i>=0; i--) {

            for(int j=m-1; j>=0; j--) {
                boolean first = ((p.charAt(j)==s.charAt(i)) || (p.charAt(j)=='.'));

                if(j + 1 < m && p.charAt(j+1) =='*') {
                    dp[i][j] = dp[i][j+2] || (first && dp[i+1][j]);
                }
                else {
                    dp[i][j] = first && dp[i+1][j+1];
                }
            }
        }
        return dp[0][0];
    }
}
