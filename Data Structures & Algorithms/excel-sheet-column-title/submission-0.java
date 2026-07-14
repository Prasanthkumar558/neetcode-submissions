class Solution {
    public String convertToTitle(int columnNumber) {

        StringBuilder ans = new StringBuilder();

        while(columnNumber > 0) {

            columnNumber--;

            int remainder = columnNumber % 26;
            char ch = (char) ('A' + remainder);

            ans.append(ch);

            columnNumber = columnNumber / 26;
        }

       return ans.reverse().toString();
        
    }
}