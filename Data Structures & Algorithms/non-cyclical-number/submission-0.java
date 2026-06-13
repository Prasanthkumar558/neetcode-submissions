class Solution {
    public boolean isHappy(int n) {
        
        HashSet<Integer> set = new HashSet<>();

        while(true) {

            int sum = getSumOfDigits(n);
            if(sum ==  1) return true;
            n = sum;
            if(set.contains(sum)) return false;
            set.add(sum);
        }

    }

    private int getSumOfDigits(int n){
        
        int sum = 0;

        while(n != 0) {
            
            int digit = n % 10;
            sum += digit * digit;
            n = n / 10;
        }
        return sum;
    }
}
