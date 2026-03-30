class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        int[] ans = new int[temperatures.length];
        
        for(int i=0;i<temperatures.length;i++){

                int count=0;
                boolean flag = false;
                for(int j= i+1 ;j<temperatures.length;j++){
                    count++;
                    if(temperatures[i]<temperatures[j]){
                        flag = true;
                        break;
                    }
                }
                if(flag){
                    ans[i] = count;
                }
        }
        return ans;
    }
}
