class Node {
    int weight;
    int node;

    public Node(int weight,int node) {
        this.weight = weight;
        this.node = node;
    }
}
class Solution {
    public int minCostConnectPoints(int[][] points) {
       
       boolean[] visited = new boolean[points.length];
       PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.weight - b.weight);

       pq.add(new Node(0,0));
       int minCost = 0;

       while(!pq.isEmpty()) {

        Node st = pq.poll();
        int u = st.node;
        int weight = st.weight;

        if(visited[u]) continue;
        visited[u] = true;
        minCost += weight;

        for(int v=0; v<points.length; v++) {
            if(!visited[v]) {
                int newWeight = Math.abs(points[u][0] - points[v][0]) + Math.abs(points[u][1] - points[v][1]);
                pq.add(new Node(newWeight,v));
            }
        }
       }
       return minCost;
    }
}
