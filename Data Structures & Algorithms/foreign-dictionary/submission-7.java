class Solution {
    public String foreignDictionary(String[] words) {

        boolean[] isPresent = new boolean[26];
        List<List<Integer>> adjList = new ArrayList<>();
        int lettersPresent = 0;
        int[] inDegree = new int[26];
        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<26; i++) {
            adjList.add(new ArrayList<>());
        }

        for(String word : words) {
            for(char ch : word.toCharArray()) {
                if(!isPresent[ch-'a']) {
                    isPresent[ch-'a'] = true;
                    lettersPresent++;
                }
            }
        }

        for(int i=0; i<words.length-1; i++) {

            String word1 = words[i];
            String word2 = words[i+1];

            if(word1.length() > word2.length() && word1.startsWith(word2)) return "";

            for(int j=0; j<Math.min(word1.length(),word2.length()); j++) {
                char ch1 = word1.charAt(j);
                char ch2 = word2.charAt(j);

                if(ch1 != ch2) {
                    adjList.get(ch1-'a').add(ch2-'a');
                    inDegree[ch2-'a']++;
                    break;
                }
            }
        }

        for(int i=0; i<26; i++) {
            if(isPresent[i] && inDegree[i] == 0) q.add(i);
        }

        StringBuilder str = new StringBuilder();

        while(!q.isEmpty()) {
            int ch = q.poll();
            str.append((char) (ch+'a'));

            for(int v : adjList.get(ch)) {
                inDegree[v]--;
                if(inDegree[v] == 0) q.add(v);
            }
        }

        if(str.length() < lettersPresent) {
            return "";
        }

        return str.toString();
    }
}
