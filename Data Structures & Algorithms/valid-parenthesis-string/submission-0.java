class Solution {
    public boolean checkValidString(String s) {

        Stack<Integer> openP = new Stack<>();
        Stack<Integer> star = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                openP.push(i);
            }
            else if(ch == '*') {
                star.push(i);
            }
            else {

                if(!openP.isEmpty()) openP.pop();
                else if(!star.isEmpty()) star.pop();
                else return false;
            }
        }

        while(!openP.isEmpty()) {
            if(star.isEmpty()) return false;
            int open = openP.pop();
            int close = star.pop();

            if(open > close) return false;
        }

        return openP.isEmpty();
    }
}
