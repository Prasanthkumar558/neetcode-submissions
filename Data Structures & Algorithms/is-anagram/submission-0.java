class Solution {
    public boolean isAnagram(String s, String t) {
       int[] sarr = new int[26];
       int[] tarr = new int[26];
       for(int i=0;i<26;i++){
        sarr[i]=0;
        tarr[i]=0;
       }
       for(int i=0;i<s.length();i++){
        int pos = s.charAt(i) - 97;
        sarr[pos]++;
       }
        for(int i=0;i<t.length();i++){
        int pos = t.charAt(i) - 97;
        tarr[pos]++;
       }
       boolean check = false;
       for(int i=0;i<26;i++){
        if(sarr[i]!=tarr[i]){
            check = false;
            break;
        }
        else{
           check= true;
        }
       }
       return check;
    }
}
