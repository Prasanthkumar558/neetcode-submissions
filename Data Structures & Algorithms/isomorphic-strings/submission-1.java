class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        return helper(s,t) && helper(t,s);
    }

    private boolean helper(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (map.containsKey(sc) && map.get(sc) != tc) {
                return false;
            }
            map.put(sc, tc);
        }
        return true;
    }
}