class Solution {
    public int scoreOfString(String s) {
        
        int absDifference = 0;

        for(int i=1; i<s.length(); i++) {

            int c1 = (int) s.charAt(i);
            int c2 = (int) s.charAt(i-1);
            
            absDifference += (int) Math.abs(c1-c2);
        }

        return absDifference;
    }
}