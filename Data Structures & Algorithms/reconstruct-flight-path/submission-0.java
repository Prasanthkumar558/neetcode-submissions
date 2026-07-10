class Solution {

    public List<String> findItinerary(List<List<String>> tickets) {

        HashMap<String,PriorityQueue<String>> map = new HashMap<>();

        for(List<String> list : tickets) {
            String u = list.get(0);
            String v = list.get(1);

            if(!map.containsKey(u)) {
                map.put(u,new PriorityQueue<>());
            }
            map.get(u).add(v);
        }

        List<String> ans = new ArrayList<>();

        dfs("JFK",map,ans);

        Collections.reverse(ans);
        return ans;
    }

    private void dfs(String airPort,HashMap<String,PriorityQueue<String>> map,List<String> path) {

        PriorityQueue<String> destinations = map.getOrDefault(airPort,new PriorityQueue<>());

        while(!destinations.isEmpty()) {
            String nextDestination = destinations.poll();

            dfs(nextDestination,map,path);
        }

        path.add(airPort);
    }
}
