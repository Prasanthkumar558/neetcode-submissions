class Solution {
    public int rangeBitwiseAnd(int left, int right) {

       while(left < right){
        right = right & (right - 1);
       }

       return right;

        //  int ans = left;
        //  for(int i=left+1; i<=right; i++) {
        //     ans = ans & i;
        //  }

        //  return ans;
    }
}