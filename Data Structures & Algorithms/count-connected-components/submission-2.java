class Solution {
    public int countComponents(int n, int[][] edges) {
    
    int[] parent = new int[n];
    for(int i=0; i<n; i++) {
        parent[i]=i;
    }    
    int components = n;
    for(int[] edge : edges) {
        int parentU = find(edge[0],parent);
        int parentV = find(edge[1],parent);

        if( parentU != parentV) {
            parent[parentV] = parent[parentU];
            components--;
        }
    }
    return components;
    }

    private int find(int node,int[] parent) {

        if(parent[node] == node) return node;

        return parent[node] = find(parent[node],parent);
    }
}
