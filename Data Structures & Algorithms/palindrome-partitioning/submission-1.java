class Solution {

    List<List<String>> ans = new ArrayList<>();
    List<String> temp = new ArrayList<>();
    
    public List<List<String>> partition(String s) {
        
        backTrack(s);
        return ans;
    }

    private void backTrack(String s) {

        if(s.length() == 0) {
            ans.add(new ArrayList<>(temp));
        }

        for(int i=0; i<s.length(); i++) {
            String str = s.substring(0,i+1);
            
            if(isPalindrome(str)) {
                temp.add(str);
                
                backTrack(s.substring(i+1));

                temp.remove(temp.size()-1);
            }
         }
    }

    private boolean isPalindrome(String s) {

        StringBuilder str = new StringBuilder(s).reverse();

        return s.equals(str.toString());
    }

}
