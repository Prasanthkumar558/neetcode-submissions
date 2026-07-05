class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        int n = accounts.size();
        int[] parent = new int[n];

        for(int i=0; i<n; i++) {
            parent[i] = i;
        }
        Map<String,Integer> map = new HashMap<>();
        
        // Union them 
        for(int i=0; i<n; i++) {

            for(int j=1; j<accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);

                if(!map.containsKey(email)) {
                    map.put(email,i);
                }
                else{
                    int parentU = find(i,parent);
                    int parentV = find(map.get(email),parent);

                    if(parentU != parentV) {
                        parent[parentU] = parentV;
                    }
                }
            }
        }

        // Group them

        Map<Integer,List<String>> group = new HashMap<>();
        for(String email : map.keySet()){
            int root = find(map.get(email),parent);
            group.computeIfAbsent(root,k -> new ArrayList<>()).add(email);
        }

        List<List<String>> ans = new ArrayList<>();

        for(int root : group.keySet()) {
            List<String> account = group.get(root);

            Collections.sort(account);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(root).get(0));
            temp.addAll(account);
            ans.add(temp);
        }
        return ans;
    }

    private int find(int node,int[] parent) {
        if(parent[node] == node) return node;

        return parent[node] = find(parent[node],parent);
    }
}