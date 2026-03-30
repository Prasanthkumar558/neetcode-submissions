class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=temperatures.length-1 ;i>=0;i--){

            while(stack.size() > 0 && temperatures[i] >= temperatures[stack.peek()]){
                stack.pop();
            }

            if(stack.size() > 0){
                int count = stack.peek() - i;
                ans[i] = count;
            }

            stack.push(i);
        }
        return ans;
    }
}
