class Node {
    int node;
    int weight;

    Node(int node,int weight) {
        this.node = node;
        this.weight = weight;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        int[] distance = new int[n+1];
        for(int i=1; i<=n; i++) {
            distance[i] = (int) 1e8;
        }
        List<List<Node>> adjList = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int[] time : times) {
            adjList.get(time[0]).add(new Node(time[1],time[2]));
        }
        distance[k] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.weight - b.weight);

        pq.add(new Node(k,0));

        while(!pq.isEmpty()) {
            Node temp = pq.poll();

            int node = temp.node;
            int weight = temp.weight;

            for(Node temp1 : adjList.get(node)) {
               
                int v = temp1.node;
                int we = temp1.weight;

                if(weight + we < distance[v]) {
                    distance[v] = weight + we;
                    pq.add(new Node(v,distance[v]));
                }
            }
        }
        int ans = 0;
        for(int i=1; i<=n; i++) {
            if(distance[i] == (int) 1e8) return -1;
            else ans = Math.max(ans,distance[i]);
        }
        return ans;
    }
}
