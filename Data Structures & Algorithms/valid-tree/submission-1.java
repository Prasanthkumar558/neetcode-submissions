class Solution {
    public boolean validTree(int n, int[][] edges) {
       if(edges.length != n -1) return false;

       ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

       for(int i=0; i<n; i++){
        adjList.add(new ArrayList<>());
       }

       for(int [] edge : edges){
        int u = edge[0];
        int v = edge[1];
        adjList.get(u).add(v);
        adjList.get(v).add(u);
       }

       boolean[] visited = new boolean[n];
       
       Queue<Integer> q = new LinkedList<>();
        int nodeCount= 1;
       q.add(0); 
       visited[0]  = true;
       while(!q.isEmpty()){
            int node = q.poll();

            for(int it : adjList.get(node)){
                if(!visited[it]){
                    visited[it] = true;
                    nodeCount++;
                    q.add(it);
                }
            }
       }

       return nodeCount == n;
    }


}
