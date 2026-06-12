class MyHashSet {

    List<Integer> hashset;

    public MyHashSet() {
        hashset = new ArrayList<>();
    }
    
    public void add(int key) {
        if(contains(key)) {
            return;
        }
        hashset.add(key);
    }
    
    public void remove(int key) {

        for(int i=0; i<hashset.size(); i++){
            if(hashset.get(i) == key) {
                hashset.remove(i);
                return;
            }
        }
        
    }
    
    public boolean contains(int key) {
        
        for(Integer ele : hashset) {
            if(key==ele) return true;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */