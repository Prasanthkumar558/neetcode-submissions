class Node{

    Node[] children;
    boolean endOfWord;

    public Node(){
        children = new Node[26];
        for(int i=0; i<26; i++){
            children[i] = null;
        }
        endOfWord = false;
    }

}
class PrefixTree {
 
    private Node root = new Node();

    public PrefixTree() {
         
    }

    public void insert(String word) {
        Node temp = root;

        for(int i=0; i<word.length(); i++) {
            int index = word.charAt(i)  - 'a';
            
            if(temp.children[index] == null){
                temp.children[index] = new Node();
            }
            if(i == word.length() - 1){
                temp.children[index].endOfWord = true;
            }

            temp = temp.children[index];
        }
    }

    public boolean search(String word) {
        Node temp = root;

        for(int i=0; i<word.length(); i++) {
            int index = word.charAt(i) - 'a';
            
            if(temp.children[index] == null){
                return false;
            }
            if(i == word.length()-1 && temp.children[index].endOfWord == false){
                return false;
            }

            temp = temp.children[index];
        }

        return true;
    }

    public boolean startsWith(String prefix) {
        Node temp = root;

        for(int i=0; i<prefix.length(); i++){
            int index = prefix.charAt(i) - 'a';

            if(temp.children[index] == null) return false;

            temp = temp.children[index];
        }

        return true;
    }
}
