class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<prerequisites.length;i++){
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int[] inDegree = new int[numCourses];
        
        int idx = 0;
        for(int i=0;i<adjList.size();i++){
            for(int node : adjList.get(i)){
                inDegree[node]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<numCourses;i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int node = q.poll();
            ans[idx++] = node;

            for(int it : adjList.get(node)){
                inDegree[it]--;
                if(inDegree[it] == 0){
                    q.add(it);
                }
            }
        }
        if(idx == numCourses) return ans;
        int[] temp = new int[0] ;
        return temp;
    }
}
