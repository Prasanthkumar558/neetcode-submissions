class Solution {
    class Pair{
        int distance;
        int index;
        public Pair(int d,int i){
            distance = d;
            index = i;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
    
    PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Integer.compare(b.distance,a.distance));

    for(int i=0;i<points.length;i++){
        int x = points[i][0];
        int y = points[i][1];
        
        int dis = (x * x) + (y * y);
        pq.add(new Pair(dis,i));

        if(pq.size() > k){
            pq.poll();
        }
    }

    int[][] ans = new int[k][2];
    int count = 0;

    while(count < k){
        Pair obj = pq.poll();
        ans[count][0] = points[obj.index][0];
        ans[count][1] = points[obj.index][1];
        count++;
    }
    return ans;
    }
}
