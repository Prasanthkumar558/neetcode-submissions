class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        
        backTrack(n,0,0,new StringBuilder());

        return ans;
    }

    private void backTrack(int n, int openParanthesis, int closeParanthesis,StringBuilder strB) {

        if(strB.length() == 2 * n) {
            ans.add(strB.toString());
            return;
        }

        if(openParanthesis < n) {
            strB.append('(');
            backTrack(n,openParanthesis+1,closeParanthesis,strB);
            strB.deleteCharAt(strB.length()-1);
        }

        if(closeParanthesis < openParanthesis) {
            strB.append(')');
            backTrack(n,openParanthesis,closeParanthesis+1,strB);
            strB.deleteCharAt(strB.length()-1);
        }
    }

}
