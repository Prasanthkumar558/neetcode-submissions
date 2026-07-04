class Solution {
    public String foreignDictionary(String[] words) {
      
      boolean[] isPresent = new boolean[26];
      int[] inDegree = new int[26];
      ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
      for(int i=0; i<26; i++) {
        adj.add(new ArrayList<>());
      }

      int lettersPresent = 0;

      for(String str : words) {

        for(char ch : str.toCharArray()) {
            if(!isPresent[ch -'a']) {
                isPresent[ch-'a'] = true;
                lettersPresent++;
            }
        }
      }

      for(int i=0; i<words.length-1; i++) {
        String word1 = words[i];
        String word2 = words[i+1];

        if(word1.length() > word2.length() && word1.startsWith(word2)) return "";

        for(int j=0; j<Math.min(word1.length(),word2.length());j++) {

            char ch1 = word1.charAt(j);
            char ch2 = word2.charAt(j);

            if(ch1 != ch2) {
                adj.get(ch1-'a').add(ch2-'a');
                inDegree[ch2-'a']++;
                break;
            }
        }
      }
    
      Queue<Integer> q = new LinkedList<>();
      StringBuilder ans = new StringBuilder();

      for(int i=0; i<26; i++ ){
        if(isPresent[i] && inDegree[i] == 0) q.add(i);
      }

        while(!q.isEmpty()) {
            int u = q.poll();
            ans.append((char) (u+'a'));

            for(int v : adj.get(u)) {
                inDegree[v]--;
                if(inDegree[v] == 0) {
                    q.add(v);
                }
            }
        }

        if(ans.length() < lettersPresent) return "";

        return ans.toString();
    }
}
