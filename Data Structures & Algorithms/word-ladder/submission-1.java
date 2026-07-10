class Node {
    String word;
    int level;
    
    public Node(String word,int level) {
        this.word = word;
        this.level = level;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        HashSet<String> set = new HashSet<>();
        for(String str : wordList) {
            set.add(str);
        }

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(beginWord,1));
        set.remove(beginWord);

        while(!q.isEmpty()) {
            Node node = q.poll();
            String word = node.word;
            int level = node.level;

            if(word.equals(endWord)) return level;

            for(int i=0; i<word.length(); i++) {

                for(char ch='a'; ch<='z'; ch++) {
                    char[] arr = word.toCharArray();
                    arr[i] = ch;
                    String newWord = new String(arr);
                    if(set.contains(newWord)) {
                        set.remove(newWord);
                        q.add(new Node(newWord,level+1));
                    }
                }
            }
        }
        return 0;
    }
}
