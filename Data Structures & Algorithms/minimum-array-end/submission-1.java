class Solution {
    public long minEnd(int n, int x) {
        
        long ans = x;
        long nthbit = n-1;
        long bitmask = 1;
        long bitposition = 1;

        while( bitmask <= nthbit){

            if((bitposition & ans) == 0){

                if((bitmask & nthbit) != 0){
                    ans |= bitposition;
                    
                }
                bitmask <<=1;
               
            }
             bitposition <<= 1;
        }
        return ans;
    }
}