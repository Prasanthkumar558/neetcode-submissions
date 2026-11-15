class MyHashMap {

    class Node {
        int key;
        int value;
        Node next;

        public Node(int key,int value) {
            this.key = key;
            this.value = value;
            next = null;
        }

    }

    Node[] arr;

    public MyHashMap() {
        arr = new Node[16];
    }
    
    public void put(int key, int value) {
        
        int index = index(key);
        Node head = arr[index];

        while(head != null) {

            if(head.key == key) {
                head.value = value;
                return;
            }

            head = head.next;
        }

        Node newNode = new Node(key,value);
        newNode.next = arr[index];
        arr[index]  = newNode;

    }
    
    public int get(int key) {

        int index = index(key);
        Node head = arr[index];

        while(head != null) {

            if(head.key == key) {
                return head.value;
            }
            head = head.next;
        }
        return -1;
        
    }
    
    public void remove(int key) {

        int index = index(key);
        Node head = arr[index];
        Node prev = null;

        while(head != null) {

            if(head.key == key) {
                if(prev != null) {
                    prev.next = head.next;
                    return;
                }
                else{
                    arr[index] = head.next;
                }
            }

            prev = head;
            head = head.next;
        }
        
    }

    public int index(int key) {
        return (int)Math.floor(key % 16);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */