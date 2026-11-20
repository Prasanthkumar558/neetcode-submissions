class Solution {
    public int findTheWinner(int n, int k) {

        List<Integer> players = new ArrayList<>();

        for(int i=1; i<=n; i++){
            players.add(i);
        }

        int index = 0;

        while(players.size() > 1){
            
            index = (index + k -1) % players.size();

            players.remove(index);
        }

        return players.get(0);
    }
}
