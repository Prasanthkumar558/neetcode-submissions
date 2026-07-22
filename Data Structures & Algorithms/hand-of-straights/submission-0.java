class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        
        if(hand.length % groupSize != 0) return false;

        TreeMap<Integer,Integer> tmap = new TreeMap<>();

        for(int i=0; i<hand.length; i++) {

            tmap.put(hand[i],tmap.getOrDefault(hand[i],0)+1);
        }

        while(!tmap.isEmpty()) {

            int ele = tmap.firstKey();

            for(int i=0; i<groupSize; i++) {
                int nextEle = ele + i;

                if(!tmap.containsKey(nextEle)) return false;

                tmap.put(nextEle,tmap.get(nextEle)-1);
                if(tmap.get(nextEle) == 0) tmap.remove(nextEle);
            }
        }
        return true;
    }
}
