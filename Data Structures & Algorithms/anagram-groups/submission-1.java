class Solution {
    public String hashcode(String s){
        int[] arr = new int[26];
        for(char c : s.toCharArray()){
            arr[c-'a']++;
        }
        StringBuilder str = new StringBuilder();
        for(int i : arr){
            str.append('#');
            str.append(i);
        }
        String str1 = str.toString();
        return str1;
    }
    public List<List<String>> groupAnagrams(String[] strs) {
            HashMap<String,List> mp = new HashMap<>();
            for(String s : strs){
                String hash = hashcode(s);
                if(mp.containsKey(hash)){
                    mp.get(hash).add(s);
                }
                else{
                    List<String> list = new ArrayList<>();
                    list.add(s);
                    mp.put(hash,list);
                }
            }
            return new ArrayList(mp.values());
    }
        
}
