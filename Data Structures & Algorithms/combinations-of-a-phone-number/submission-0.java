class Solution {
    String[] map= {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> ans = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if(digits.length() ==0){
            return ans;
        }
        StringBuilder str = new StringBuilder();

        getAllCombinations(digits,str,0);
        return ans;
    }

    public void getAllCombinations(String digits,StringBuilder str,int index){
        if(index == digits.length()){
            ans.add(str.toString());
            return;
        }
        String numberString = map[digits.charAt(index)-'0'];

        for(char ch : numberString.toCharArray()){
            str.append(ch);
            getAllCombinations(digits,str,index+1);
            str.deleteCharAt(str.length() -1);
        }
    }
}
