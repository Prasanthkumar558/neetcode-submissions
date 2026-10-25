class Solution {
    public String kthDistinct(String[] arr, int k) {
        
        LinkedHashMap<String,Integer> map = new LinkedHashMap<>();

        for(String word : arr) {
            map.put(word,map.getOrDefault(word,0)+1);
        }

        for(String key : map.keySet()) {
            int value = map.get(key);
            if(value == 1) {
                if(k > 1)k--;
                else{
                    return key;
                }
            }
        }

        return "";
    }
}