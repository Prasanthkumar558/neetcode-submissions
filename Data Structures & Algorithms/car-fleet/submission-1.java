class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
        int[][] cars = new int[position.length][2];
        for(int i=0;i<position.length;i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars , (a,b) -> Integer.compare(b[0],a[0]));

        int carFleets = 1;
        double prevTime = (double) (target - cars[0][0])/cars[0][1];

        for(int i=1 ;i<position.length;i++){
            double currentTime = (double) (target - cars[i][0])/cars[i][1];
            if(currentTime > prevTime){
                carFleets++;
                prevTime = currentTime;
            }
        }
        return carFleets;
    }
}
