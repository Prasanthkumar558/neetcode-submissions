class Solution {
    public int calPoints(String[] operations) {
        
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<operations.length; i++) {

            String ch = operations[i];
            
            if(ch.equals("+")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a);
                stack.push(b);
                stack.push(a+b);
            }
            else if(ch.equals("D")){
                int ele = stack.pop();
                stack.push(ele);
                stack.push(2*ele);
            }
            else if(ch.equals("C")){
               int ele = stack.pop();
            }
            else{
                stack.push(Integer.parseInt(ch));
            }
        }

        int sum = 0;
        while(!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;
    }
}