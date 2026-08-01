class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        int n = intervals.length;

        int count = 1;
        Arrays.sort(intervals,(a,b) -> a[1] - b[1]);
        int lastTime = intervals[0][1];

        for(int i=1; i<n; i++) {

            if(intervals[i][0] >= lastTime) {
                count += 1;
                lastTime = intervals[i][1];
            }
        }
        return n-count;
    }
}
