class Solution {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b,a));

        for(int stone : stones){
            pq.offer(stone);
        }

        while(pq.size() > 1){
            int y = pq.poll();
            int x = pq.poll();
            
            if(x == y) continue;

            if(x < y) {
                pq.add(y-x);
            }
        }
        if(pq.isEmpty()){
            return 0;
        }
        else{
            return pq.peek();
        }
    }
}
