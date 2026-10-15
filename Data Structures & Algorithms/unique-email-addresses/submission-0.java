class Solution {
    public int numUniqueEmails(String[] emails) {
        
        Set<String> uniqueSet = new HashSet<>();

        for(String email : emails) {
            String[] mail = email.split("@");
            String local = mail[0];
            String domain = mail[1];

            int indexOfPlus = local.indexOf('+');
            if(indexOfPlus != -1) {
                local = local.substring(0,indexOfPlus);
            }

            local = local.replace(".","");
            uniqueSet.add(local + "@" + domain);
        }

        return uniqueSet.size();
    }
}