class Solution {
    public int[][] merge(int[][] intervals) {

        if(intervals.length <= 1) return intervals;

        int n = intervals.length;

        Arrays.sort(intervals,(a,b) -> a[0]-b[0]);
        List<int[]> ans = new ArrayList<>();
        int[] lastInterval = intervals[0];
        ans.add(lastInterval);

        for(int[] interval : intervals) {

            if(interval[0] <= lastInterval[1]) {
                lastInterval[1] = Math.max(lastInterval[1], interval[1]);
            }
            else{
                lastInterval = interval;
                ans.add(lastInterval);
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
