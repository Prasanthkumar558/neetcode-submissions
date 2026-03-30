class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<tokens.length;i++){
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || 
                tokens[i].equals("/")){
                int num2 = stack.pop();
                int num1 = stack.pop();

                int sol = 0;
                if(tokens[i].equals("+")){
                    sol = num1 + num2;
                }
                else if(tokens[i].equals("-")){
                    sol = num1 - num2;
                }
                else if(tokens[i].equals("*")){
                    sol = num1 * num2;
                }
                else if(tokens[i].equals("/")){
                    sol = num1 / num2;
                }
                stack.push(sol);
            }
            else{
                Integer ele = Integer.parseInt(tokens[i]);
                stack.push(ele);
            }
        }

        int ans = stack.peek();
        return ans;
        
    }
}
