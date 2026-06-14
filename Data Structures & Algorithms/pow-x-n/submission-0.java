class Solution {
    public double myPow(double x, int n) {
        
        int pow = n;
        if( n < 0 ) {
            x = 1 / x;
            pow = -pow;
        }

        double currentResult = x;
        double result = 1.0;
        while(pow != 0) {
            
            if(pow %2 != 0) {
                result *= currentResult;
            }

            currentResult = currentResult * currentResult;

            pow = pow / 2;
        }

        return result;
    }
}
