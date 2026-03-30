class Solution {
    public boolean contains(int[] mapT,int[] mapS){
        for(int i=0;i<257;i++){
            if(mapT[i]>mapS[i]) return false;
        }
        return true;
    }
    public String minWindow(String s, String t) {
        
        int[] mapS = new int[257];
        int[] mapT = new int[257];

        for(char ch : t.toCharArray()){
            mapT[ch]++;
        }

        int left = 0, right = 0 ,start = -1 , minlength = Integer.MAX_VALUE;
        for(;right<s.length();right++){
            mapS[s.charAt(right)]++;

            while(contains(mapT,mapS)){
                if(right - left + 1 < minlength){
                    minlength = right - left + 1;
                    start = left;
                }
                mapS[s.charAt(left++)]--;
            }
        }
        return minlength == Integer.MAX_VALUE ? "" : s.substring(start,start+minlength);
    }
}
