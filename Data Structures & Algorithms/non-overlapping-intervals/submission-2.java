class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        int n = intervals.length;

        Arrays.sort(intervals, (a,b) -> a[1]-b[1]);

        int[] lastInterval = intervals[0];
        int count = 1;

        for(int i=1; i<n; i++) {

            if(intervals[i][0] >= lastInterval[1]) {
                count++;
                lastInterval = intervals[i];
            }
        }

        return n-count;
    }
}
