class LRUCache {
    class Node {
        int key,val;
        Node next;
        Node prev;

        Node(int k,int v){
            key = k;
            val = v;
            next = null;
            prev = null;
        }
    }
    int limit;
    Node head = new Node(-1,-1);
    Node tail = new Node(-1,-1);
    HashMap<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        limit = capacity;
        head.next = tail;
        tail.prev = head;
    }

    void deleteNode(Node node){   
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    void addNode(Node node){
        Node nextNode = head.next;
        head.next = node;
        node.next = nextNode;
        node.prev = head;
        nextNode.prev = node;
    }
    
    public int get(int key) {

        if(!map.containsKey(key)){
            return -1;
        }

        Node oldNode = map.get(key);
        int ans = oldNode.val;
  
        deleteNode(oldNode);
        map.remove(key);
        map.put(key,oldNode);
        addNode(oldNode);
       
        return ans;
    }
    
    public void put(int key, int value) {

        if(map.containsKey(key)){
            Node oldNode = map.get(key);
            deleteNode(oldNode);
            map.remove(key);
        }

        if(map.size()==limit){
            map.remove(tail.prev.key);
            deleteNode(tail.prev);     
        }

        Node newNode = new Node(key,value);
        addNode(newNode);
        map.put(key,newNode);
             
    }
}
