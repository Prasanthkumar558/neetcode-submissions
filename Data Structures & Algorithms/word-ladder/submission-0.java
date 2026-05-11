class Pair{
    String word;
    int level;

    Pair(String w,int l){
        word = w;
        level = l;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> set = new HashSet<>();

        for(String str : wordList) {
            set.add(str);
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,1));
        set.remove(beginWord);

        while(!q.isEmpty()){

            Pair node = q.poll();
            String word = node.word;
            int level = node.level;

            if(word.equals(endWord)) return level;

            for(int i=0;i<word.length();i++){

                for(char ch = 'a'; ch<='z'; ch++){
                    char[] chArray = word.toCharArray();
                    chArray[i] = ch;
                    String newWord = new String(chArray);

                    if(set.contains(newWord)){
                        q.add(new Pair(newWord,level+1));
                        set.remove(newWord);
                    }
                }
            }
        }
        return 0;
        
    }
}
