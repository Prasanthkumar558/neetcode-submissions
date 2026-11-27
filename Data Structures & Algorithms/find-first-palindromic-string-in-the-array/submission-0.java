class Solution {
    public String firstPalindrome(String[] words) {

        for(int i=0; i<words.length; i++){

            StringBuilder str = new StringBuilder(words[i]);
            if(words[i].equals(str.reverse().toString())){
                return words[i];
            }
        }

        return "";
    }
}
