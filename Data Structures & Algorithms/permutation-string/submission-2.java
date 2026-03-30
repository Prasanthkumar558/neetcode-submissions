class Solution {
    public boolean isFrequencySame(int[] f1,int[] f2){
        for(int i=0;i<27;i++){
            if(f1[i]!=f2[i]){
                return false;
            }
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        
        int[] frequencyS1 = new int[27];
        
        for(int i=0;i<s1.length();i++){
            char ch = s1.charAt(i);
            frequencyS1[ch-'a']++;
        }

        int windowSize = s1.length();

        for(int i=0;i<s2.length();i++){
            int presentWindowSize = 0;
            int idxWindow = i;
            int[] frequencyOfWindow = new int[27];

            while(presentWindowSize < windowSize && idxWindow < s2.length()){
                char ch = s2.charAt(idxWindow);
                frequencyOfWindow[ch-'a']++;
                presentWindowSize++;
                idxWindow++;
            } 

            if(isFrequencySame(frequencyS1,frequencyOfWindow)){
                return true;
            }
        }
        return false;
    }
}
