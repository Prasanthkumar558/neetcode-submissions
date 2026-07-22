class Solution {
    public String predictPartyVictory(String senate) {
        
        Queue<Integer> rq = new LinkedList<>();
        Queue<Integer> dq = new LinkedList<>();

        int n = senate.length();

        for(int i=0; i<n; i++) {
            if(senate.charAt(i) == 'R') rq.add(i);
            else dq.add(i);
        }

        while(rq.size() > 0 && dq.size() > 0) {

            int ridx = rq.poll();
            int didx = dq.poll();

            if(ridx < didx) {
                rq.add(didx+n);
            }
            else if (didx < ridx){
                dq.add(ridx+n);
            }
        }

        return rq.size() > dq.size() ? "Radiant" : "Dire";
    }
}