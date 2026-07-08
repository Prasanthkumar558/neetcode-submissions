class Pair {
    int node;
    int weight;

    public Pair(int node,int weight) {
        this.node = node;
        this.weight = weight;
    }
}
class Node {
    int dst;
    int weight;
    int stops;

    public Node(int dst,int weight,int stops){
        this.dst = dst;
        this.weight = weight;
        this.stops = stops;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        int[] distance = new int[n];
        ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();

        for(int i=0; i<n; i++) {
            adjList.add(new ArrayList<>());
        }
        for(int[] flight : flights) {
            adjList.get(flight[0]).add(new Pair(flight[1],flight[2]));
        }
        for(int i=0; i<n; i++) {
            distance[i] = (int) 1e8;
        }
        distance[src] = 0;
        q.add(new Node(src,0,0));

        while(!q.isEmpty()) {
            Node u = q.poll();

            if(u.stops > k) continue;
            int weight = u.weight;

            for(Pair pair : adjList.get(u.dst)) {
                int wt = pair.weight;
                int v = pair.node;

                if(weight + wt < distance[v] && u.stops <= k) {
                    distance[v] = weight + wt;
                    q.add(new Node(v,distance[v],u.stops+1));
                }
            }
        }
        if(distance[dst] == (int) 1e8) return -1;
        else return distance[dst];
    }
}
