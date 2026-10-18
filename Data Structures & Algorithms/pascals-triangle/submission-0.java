class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> pascalTriangle = new ArrayList<>();

        for(int i=1; i<=numRows; i++) {
            pascalTriangle.add(getRow(i));
        }

        return pascalTriangle;
    }

    private List<Integer> getRow(int row) {

        List<Integer> ans = new ArrayList<>();
        int val = 1;
        ans.add(1);

        for(int i=1; i<row; i++) {
            val = val * (row - i);
            val = val / i;
            ans.add(val);
        }

        return ans;
    }
}