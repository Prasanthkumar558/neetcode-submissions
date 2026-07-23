class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {

       boolean[] matched = new boolean[3];

       for(int[] triplet : triplets) {

        if(triplet[0] > target[0] || triplet[1] > target[1] || triplet[2] > target[2]) continue;

        if(triplet[0] == target[0]) matched[0]=true;
        if(triplet[1] == target[1]) matched[1] = true;
        if(triplet[2] == target[2]) matched[2] = true;

        if(matched[0] && matched[1] && matched[2]) return true;
       }

       return matched[0] && matched[1] && matched[2];
    }
}
