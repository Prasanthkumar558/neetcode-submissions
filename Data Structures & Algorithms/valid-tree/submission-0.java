class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1) return false;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for(int i=0; i<n;i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0; i<edges.length;i++){
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }

        boolean[] visited = new boolean[n];
        
        Queue<Integer> q = new LinkedList<>();
        int nodeCount = 1;

        q.add(0);
        visited[0] = true;
        while(!q.isEmpty()){
            int node = q.poll();
            

            for(int it : adjList.get(node)){
                if(!visited[it]){
                    nodeCount++;
                    visited[it] = true;
                    q.add(it);
                }
            }
        }

        return nodeCount==n;
    }
}
