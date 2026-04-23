class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        getAllParantesis(n,0,0, "");
        return ans;
    }

    public void getAllParantesis(int n,int open,int close,String str){
        if(str.length() == 2 * n){
            ans.add(str);
        }

        if(open < n){
            getAllParantesis(n,open+1,close,str+'(');

        }
        if(close < open){
            getAllParantesis(n,open,close+1,str+')');
        }
    }
}
