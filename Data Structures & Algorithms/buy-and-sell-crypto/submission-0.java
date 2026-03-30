class Solution {
    public int maxProfit(int[] prices) {
        int ans=0;
        
        for(int i=0;i<prices.length;i++){
            int purchasePrice = prices[i];
            for(int j=i+1;j<prices.length;j++){
                int sellingPrice = prices[j];
                if(sellingPrice < purchasePrice) continue;
                else{
                    int profit = sellingPrice - purchasePrice;
                    ans = Math.max(ans,profit);
                }
            }
        }
        return ans;
    }
}
