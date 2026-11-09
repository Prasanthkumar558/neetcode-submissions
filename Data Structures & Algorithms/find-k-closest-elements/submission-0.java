class Pair{
    int a;
    int val;
    
    public Pair(int a, int val){
        this.a = a;
        this.val = val;
    }
}

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
                                                     if(a.val != b.val) {
                                                     return b.val - a.val;
                                                         }
                                                    return b.a - a.a;
                                                    });

        for(int i=0; i<arr.length; i++) {

            int val = Math.abs(arr[i]-x);
            pq.add(new Pair(arr[i], val));
            
            if(pq.size() > k){
                pq.poll();
            }
        }

        List<Integer> ans = new ArrayList<>();

        while(!pq.isEmpty()){
            ans.add(pq.poll().a);
        }

        Collections.sort(ans);
        return ans;
    }
}