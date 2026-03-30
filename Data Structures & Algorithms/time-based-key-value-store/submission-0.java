class TimeMap {
    HashMap<String, List<Pair<String,Integer>>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    public void set(String key, String value, int timestamp) {     
        map.putIfAbsent(key,new ArrayList<>());
        map.get(key).add(new Pair(value,timestamp));
    }  
    public String get(String key, int timestamp) {
        String ans = "";
        if(map.containsKey(key)){
            List<Pair<String,Integer>> list = map.get(key);
            int start = 0;
            int end = list.size() - 1;
            while(start <= end){
                int mid = start + (end - start)/2;
                if(list.get(mid).getValue() > timestamp){
                   end = mid - 1;
                }
                else{    
                    ans = list.get(mid).getKey();
                    start = mid + 1;
                }
            }
        }
        return ans;
    }
}
