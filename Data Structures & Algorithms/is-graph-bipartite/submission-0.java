class Solution {
    public boolean isBipartite(int[][] graph) {

        List<List<Integer>> adjList = new ArrayList<>();
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color,-1);

        for(int i=0; i<n; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int u=0; u<n; u++) {
            for(int v : graph[u]) {
                adjList.get(u).add(v);
            }
        }

        for(int i=0; i<n; i++) {
            if(color[i] == -1) {
                if(colorTheGraph(adjList,color,i) == false){
                    return false;
                }
            }
        }

        return true;
    }

    private boolean colorTheGraph(List<List<Integer>> adjList, int[] color, int start) {

        color[start] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()) {
            int u = q.poll();

            for(int v : adjList.get(u)) {
                if(color[v] == -1) {
                    color[v] = 1 - color[u];
                    q.add(v);
                }
                if(color[u] == color[v]) return false;
            }
        }

        return true;
    }
}
