class Solution {
    public String simplifyPath(String path) {
        
        Stack<String> stack = new Stack<>();

        String[] paths = path.split("/");

        for(String p : paths){

            if(p.equals("") || p.equals(".")) continue;

            if(p.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
            else{
                stack.push(p);
            }
        }

        StringBuilder str = new StringBuilder();

        for(String string : stack){
            str.append("/");
            str.append(string);
        }

        return str.length() == 0 ? "/" : str.toString();
    }
}