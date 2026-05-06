class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            adjList.add(new ArrayList<>());
        }

        int m = prerequisites.length;

        for(int i=0 ; i<m; i++){
            adjList.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        Queue<Integer> q = new LinkedList<>();

        int[] inDegree = new int[numCourses];

        for(int i=0; i<adjList.size();i++){
            for(int node : adjList.get(i)){
                inDegree[node]++;
            }
        }
        for(int i=0;i<numCourses;i++){
            if(inDegree[i] == 0) q.add(i);
        }
        ArrayList<Integer> orderOfCourses= new ArrayList<>();

        while(!q.isEmpty()){
            int node = q.poll();
            orderOfCourses.add(node);

            for(int it : adjList.get(node)){
                inDegree[it]--;
                if(inDegree[it] == 0) {
                    q.add(it);
                }
            }

        }

        if(orderOfCourses.size() == numCourses) {
            return true;
        }
        return false;
    }
}
