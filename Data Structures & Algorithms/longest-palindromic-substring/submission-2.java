class Solution {

    // String longestCommonSubSequence(String s,String t) {
    //     int n = s.length();
    //     int m = t.length();

    //     int[][] dp = new int[n+1][m+1];

    //     for(int i=1; i<=n; i++){

    //         for(int j=1; j<=m; j++) {
    //             if(s.charAt(i-1) == t.charAt(j-1)){
    //                 dp[i][j] = 1 + dp[i-1][j-1];
    //             }
    //             else{
    //                 dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
    //             }
    //         }
    //     }
    //     //return dp[n][m]
        
    //     int i=n,j=m;

    //     StringBuilder ans = new StringBuilder();

    //     while( i>0 && j > 0 ) {

    //         if(s.charAt(i-1) == t.charAt(j-1)) {
    //             ans.append(s.charAt(i-1));
    //             i--;
    //             j--;
    //         }
    //         else if(dp[i-1][j] > dp[i][j-1]) {
    //             i--;
    //         }
    //         else{
    //             j--;
    //         }
    //     }
    //     return ans.toString();
    // }
    public String longestPalindrome(String s) {
        
      int start = 0;
      int end = 0;

    //   int maxAns = Integer.MIN_VALUE;

      for(int i=0; i<s.length(); i++) {

        int odd = get(s,i,i);
        int even = get(s,i,i+1);

        int maxLength = Math.max(odd,even);

        if(maxLength > (end- start)) {
            start = i - (maxLength-1) /2;
            end = i + maxLength/2;
        }
      }

        return s.substring(start,end+1);

    }

    public int get(String s,int left,int right) {

        while(left>=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left -1;
    }
}
