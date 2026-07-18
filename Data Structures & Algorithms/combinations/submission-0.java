class Solution {
    
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {

        backTrack(n,k);    
        return ans;
    }

    private void backTrack(int n,int k) {
        if(k ==0 ){
            ans.add(new ArrayList<>(temp));
            return;
        }

        if(n==0) return;

        temp.add(n);
        backTrack(n-1,k-1);

        temp.remove(temp.size() -1);
        backTrack(n-1,k);
    }
}