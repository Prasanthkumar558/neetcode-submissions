class Solution {
    public long minEnd(int n, int x) {
       
       long ans = x;
       long bitmask = 1;
       long bitposition = 1;
       long nthbit = n -1;

       while(bitmask <= nthbit){

        if((ans & bitposition) == 0){
            if((bitmask & nthbit) != 0){
                ans |= bitposition;
            }
            bitmask = bitmask << 1;
        }
        bitposition = bitposition << 1;
       }

       return ans;
    }
}