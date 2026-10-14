class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] ans = new int[2];
        int a = 0;
        int b = 0;

        for(int i=0; i<grid.length; i++) {

            for(int j=0; j<grid.length; j++) {
                
                int num = grid[i][j];
                map.put(num,map.getOrDefault(num,0)+1);
            }
        } 

        for(int i=1; i<=Math.pow(grid.length,2); i++) {

            if(!map.containsKey(i)) {
                b=i;
            }
            else{
                if(map.get(i) == 2){
                a=i;
            }
            }
        }

        ans[0] = a;
        ans[1] = b;

        return ans;
    }
}