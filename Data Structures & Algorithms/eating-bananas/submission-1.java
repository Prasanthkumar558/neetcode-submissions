class Solution {
    public int maxPiles(int[] piles){
        int maxEle = Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++){
            if(piles[i] > maxEle){
                maxEle = piles[i];
            }
        }
        return maxEle;
    }
    
    public int timeToEat(int[] piles, int bananas){
        double timeConsume = 0;
        for(int i=0;i<piles.length;i++){
            timeConsume +=  Math.ceil((double)piles[i]/bananas);
        }
        return (int)timeConsume;
    }

    public int minEatingSpeed(int[] piles, int h) {

        int maxP = maxPiles(piles);
        int low = 1;
        int high = maxP;

        while(low <= high){
            
            int mid = low + (high - low)/2;
            int timeTaken = timeToEat(piles,mid);

            if(timeTaken > h){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }

        }
        return low;
    }
}
