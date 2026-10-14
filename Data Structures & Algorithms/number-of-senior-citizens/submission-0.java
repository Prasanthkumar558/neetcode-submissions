class Solution {
    public int countSeniors(String[] details) {
        
        int olderAgeCount = 0;

        for(String str : details) {

            String subString = str.substring(11,13);
            int age = Integer.parseInt(subString);

            
            if(age > 60) {
                olderAgeCount++;
            }
        }

        return olderAgeCount;
    }
}