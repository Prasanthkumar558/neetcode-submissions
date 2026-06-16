class Node {
    int weight;
    int destination;

    public Node(int w,int d) {
        weight = w;
        destination = d;        
    }
}
class Solution {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.weight - b.weight);

        boolean[] visited = new boolean[points.length];
        int minCost = 0;
        pq.add(new Node(0,0));

        while(!pq.isEmpty()) {
            
            Node node = pq.poll();
            int u = node.destination;
            

            if(visited[u]) continue;
            minCost += node.weight;
            visited[u] = true;

            for(int v=0; v<points.length; v++) {
                if(!visited[v]) {
                    
                    int weight = Math.abs(points[u][0] - points[v][0]) + Math.abs(points[u][1] - points[v][1]);
                    pq.add(new Node(weight,v));
                }
            }
        }
        return minCost;
    }
}
