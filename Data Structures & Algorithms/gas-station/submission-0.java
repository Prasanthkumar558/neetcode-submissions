class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int totalGas = 0;
        int costGas = 0;

        for(int i=0; i<gas.length; i++) {
            totalGas += gas[i];
            costGas += cost[i];
        }

        if(totalGas < costGas) return -1;

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
