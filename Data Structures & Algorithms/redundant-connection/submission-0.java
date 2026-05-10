class Solution {
    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length +1;
        int[] parent = new int[n];

        for(int i=0;i<n;i++){
            parent[i] = i;
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            int rootU = find(u,parent);
            int rootV = find(v,parent);

            if(rootU == rootV) return edge;

            parent[rootV] = rootU; 
        }

        int[] dup = new int[0];
        return dup;
        
    }

    int find(int node,int[] parent){
        if(parent[node] == node) return node;

        return parent[node] = find(parent[node],parent);
    }
}
