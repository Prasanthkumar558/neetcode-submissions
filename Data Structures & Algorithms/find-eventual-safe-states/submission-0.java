class Solution {
    public int[] eventualSafeNodes(int[][] graph) {

        int n = graph.length;
        List<List<Integer>> revAdjList = new ArrayList<>();
        int[] inDegree = new int[n];
        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<n; i++) {
            revAdjList.add(new ArrayList<>());
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<graph[i].length; j++) {
                int v = graph[i][j];

                revAdjList.get(v).add(i);
                inDegree[i]++;
            }
        }

        for(int i=0; i<n; i++) {
            if(inDegree[i] == 0) q.add(i);
        }

        int[] safeStates = new int[n];
        int j=0;

        while(!q.isEmpty()) {
            int node = q.poll();
            safeStates[j++] = node;

            for(int it : revAdjList.get(node)) {
                inDegree[it]--;
                if(inDegree[it] == 0) q.add(it);
            }
        }

        int[] finalSafeStates = Arrays.copyOf(safeStates,j);
        Arrays.sort(finalSafeStates);

        return finalSafeStates;
    }
}
