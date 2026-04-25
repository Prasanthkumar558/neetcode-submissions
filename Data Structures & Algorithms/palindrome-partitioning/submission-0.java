class Solution {
    List<List<String>> ans= new ArrayList<>();
    List<String> temp = new ArrayList<>();
    public List<List<String>> partition(String s) {
        getAllPartitions(s);
        return ans;
    }

    public boolean isPalindrome(String s){
        StringBuilder s1 = new StringBuilder(s).reverse();
        return s.equals(s1.toString());
    }
    public void getAllPartitions(String s){
        
        if(s.length()==0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<s.length();i++){
            String sub = s.substring(0,i+1);
            if(isPalindrome(sub)){
                temp.add(sub);
                getAllPartitions(s.substring(i+1));
                temp.remove(temp.size()-1);
            }
        }
    }
}
