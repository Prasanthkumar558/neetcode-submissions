class Solution {
    public List<String> stringMatching(String[] words) {
        
        List<String> matchedStrings = new ArrayList<>();

        for(int i=0; i<words.length; i++) {
            
            String firstWord = words[i];

            for(int j=0; j<words.length; j++) {

                if(i != j) {
                    String secondWord = words[j];

                    if(secondWord.contains(firstWord)) {
                        matchedStrings.add(firstWord);
                        break;
                    }
                }
            }
        }

        return matchedStrings;
    }
}