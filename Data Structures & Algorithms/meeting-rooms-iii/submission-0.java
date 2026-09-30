class Node {

    int end;
    int room;

    public Node(int end, int room) {
        this.end = end;
        this.room = room;
    }
}
class Solution {
    public int mostBooked(int n, int[][] meetings) {
        
        int[] meetingRooms = new int[n];
        PriorityQueue<Integer> emptyRooms = new PriorityQueue<>();
        PriorityQueue<Node> engagedRooms = new PriorityQueue<>((a,b) -> {
            if(a.end != b.end) return Integer.compare(a.end,b.end);
            return Integer.compare(a.room,b.room);
        });

        Arrays.sort(meetings,(a,b) -> a[0]-b[0]);

        for(int i=0; i<n; i++) {
            emptyRooms.add(i);
        }

        for(int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];
            int duration = end - start;
            
            while(!engagedRooms.isEmpty() && engagedRooms.peek().end <= start) {
                emptyRooms.add(engagedRooms.poll().room);
            }

            if(!emptyRooms.isEmpty()) {
                int room = emptyRooms.poll();
                meetingRooms[room]++;
                engagedRooms.add(new Node(end,room));
            }
            else{
                Node earliestRoom = engagedRooms.poll();
                int newDuration = earliestRoom.end + duration;
                meetingRooms[earliestRoom.room]++;
                engagedRooms.add(new Node(newDuration,earliestRoom.room));
            }
        }

        int maxRoom = 0;

        for(int i=1; i<n; i++) {
            if(meetingRooms[maxRoom] < meetingRooms[i]) {
                maxRoom = i;
            }
        }

        return maxRoom;
    }
}