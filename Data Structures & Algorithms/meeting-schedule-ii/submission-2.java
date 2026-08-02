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
    public int minMeetingRooms(List<Interval> intervals) {
        
        if(intervals == null || intervals.isEmpty()) return 0;
        Collections.sort(intervals, (a,b)-> a.start-b.start);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(Interval interval : intervals) {

            if(pq.isEmpty()) {
                pq.add(interval.end);
                continue;
            }

            if(pq.peek() <= interval.start) {
                pq.remove();
            }

            pq.add(interval.end);
        }

        return pq.size();
    }
}
