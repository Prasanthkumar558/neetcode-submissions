class Solution {

    public String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();

        for(String str : strs){
            encodedString.append(str.length()).append("@").append(str);
        }

        return encodedString.toString();
    }

    public List<String> decode(String str) {
       List<String> ans = new ArrayList<>();

       int i=0;

       while(i < str.length()){

        int j = str.indexOf("@",i);
        int length = Integer.parseInt(str.substring(i,j));
        String word = str.substring(j+1,j+1+length);
        i = j+1+length;
        ans.add(word);
       }
       return ans;
    }
}
