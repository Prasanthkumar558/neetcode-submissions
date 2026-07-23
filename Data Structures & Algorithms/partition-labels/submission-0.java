class Solution {
    public List<Integer> partitionLabels(String s) {

        List<Integer> ans = new ArrayList<>();

        for(int i=0; i<s.length();){

            int startIdx = i;
            int endIdx = s.lastIndexOf(s.charAt(startIdx));

            for(int str=startIdx + 1; str<endIdx; str++) {

                int lastIndexOfNextChar = s.lastIndexOf(s.charAt(str));

                if(lastIndexOfNextChar > endIdx) endIdx = lastIndexOfNextChar;

                
            }
            
            ans.add(endIdx - startIdx + 1);
            i = endIdx + 1;
        }
        return ans;
    }
}
