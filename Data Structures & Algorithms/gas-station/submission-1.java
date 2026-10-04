class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
 
        int totalGas = Arrays.stream(gas).boxed()
                                        .reduce(0, (a,b) -> a + b);
        int totalCost = Arrays.stream(cost).boxed()
                                         .reduce(0,(a,b) -> a + b);
                        
        if(totalGas < totalCost) return -1;

        int start = 0;
        int currentGas = 0;

        for(int i=0; i<gas.length; i++) {
            currentGas += gas[i] - cost[i];

            if(currentGas < 0) {
                start = i + 1;
                currentGas = 0;
            }
        }

        return start;
    }
}
