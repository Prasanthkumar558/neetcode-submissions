class Solution {
    public String hash(String s){
        int[] arr = new int[26];
        for(char c : s.toCharArray()){
            arr[c-'a']++;
        }
        StringBuilder s1 = new StringBuilder();
        for(int i : arr){
            s1.append('#');
            s1.append(i);
        }
        String hashStr = s1.toString();
        return hashStr;
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List> mp = new HashMap<>();
        for(String s : strs){
            String hashcode = hash(s);
            if(mp.containsKey(hashcode)){
                mp.get(hashcode).add(s);
            }
            else{
                List<String> ls1 = new ArrayList<>();
                ls1.add(s);
                mp.put(hashcode,ls1);

            }
        }
        return new ArrayList(mp.values());
    }
        
}
