class Solution {
    public boolean lemonadeChange(int[] bills) {
        
        int fiveCoins = 0;
        int tenCoins = 0;

        for(int i=0; i<bills.length; i++) {

            if(bills[i] == 5){
                fiveCoins++;
                continue;
            }
            else if(bills[i] == 10) {
                if(fiveCoins > 0){
                    fiveCoins--;
                    tenCoins++;
                }
                else{
                    return false;
                }
            }
            else{

                if(fiveCoins > 0 && tenCoins > 0) {
                    fiveCoins--;
                    tenCoins--;
                }
                else if(fiveCoins >= 3) {
                    fiveCoins -= 3;
                }
                else{
                    return false;
                }
            }
        }

        return true;
    }
}