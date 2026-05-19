class Solution {
    public String addBinary(String a, String b) {
        
        StringBuilder ans = new StringBuilder();

        int ai = a.length() -1;
        int bi = b.length() -1;
        int carry = 0;

        while(ai>=0 || bi>=0 || carry>0){
            int sum = carry;

            if(ai>=0){
                sum += a.charAt(ai) - '0';
                ai--;
            }

            if(bi>=0){
                sum+=b.charAt(bi) - '0';
                bi--;
            }

            ans.append(sum %2);
            carry = sum/2;
        }

        return ans.reverse().toString();
    }
}