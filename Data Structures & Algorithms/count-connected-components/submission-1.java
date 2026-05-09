class Solution {
    public int countComponents(int n, int[][] edges) {
        
        int[] parent = new int[n];

        for(int i=0;i<n;i++){
            parent[i] = i;
        }

        int components = n;

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            int parentU = find(u,parent);
            int parentV = find(v,parent);

            if(parentU != parentV){
                components--;
                parent[parentV] = parent[parentU];
            }
        }
        return components;
    }
    private int find(int node,int[] parent){

        if(parent[node] == node) return node;

        return parent[node]=find(parent[node],parent);
    }
}
