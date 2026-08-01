/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {

        Collections.sort(intervals,(a,b) -> a.start-b.start);

        for(int i=1; i<intervals.size(); i++) {
            Interval prev = intervals.get(i-1);
            Interval curr = intervals.get(i);

            if(prev.end > curr.start) return false;
        }

        return true;
    }
}
