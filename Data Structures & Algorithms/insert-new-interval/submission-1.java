class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        int[][] ans = new int[intervals.length + 1][2];
        int n = intervals.length;

        int i=0;
        int j=0;

        while(i < n && intervals[i][1] < newInterval[0]) {
            ans[j++] = intervals[i++];
        }

        while(i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0],newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1],newInterval[1]);
            i++;
        }

        ans[j++] = newInterval;

        while(i < n) {
            ans[j++] = intervals[i++];
        }

        return Arrays.copyOf(ans,j);
    }
}
