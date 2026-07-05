class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        
        int n = edges.length + 1;
        int[] parent = new int[n];

        for(int i=0; i<n; i++) {
            parent[i] = i;
        }

        for(int[] edge : edges) {
            int parentU = find(edge[0],parent);
            int parentV = find(edge[1],parent);

            if(parentU == parentV) return edge;

            parent[parentU] = parentV;
        }

        return new int[0];
    }

    private int find(int node, int[] parent) {
        
        if(parent[node] == node) return node;
 
        return parent[node] = find(parent[node],parent);
    }
}
