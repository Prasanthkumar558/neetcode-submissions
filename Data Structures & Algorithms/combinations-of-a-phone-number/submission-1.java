class Solution {
    List<String> ans = new ArrayList<>();
    String[] arr = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public List<String> letterCombinations(String digits) {
    
      if(digits.length() == 0) return ans;
      backTrack(digits,0,new StringBuilder());
      return ans;

    }

    private void backTrack(String digits,int idx,StringBuilder str) {

        if(idx == digits.length()){
            ans.add(str.toString());
            return;
        }

        String word = arr[digits.charAt(idx)-'0'];

        for(char ch : word.toCharArray()) {
            str.append(ch);
            backTrack(digits,idx+1,str);
            str.deleteCharAt(str.length()-1);
        }
    }

    
}
