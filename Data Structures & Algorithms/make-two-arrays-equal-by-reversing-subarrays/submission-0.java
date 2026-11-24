class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {

        int[] frequency = new int[1001];

        for(int i=0; i<target.length; i++){
            frequency[target[i]]++;
        }

        for(int i=0; i<arr.length; i++){
            frequency[arr[i]]--;
        }

        for(int i=0; i<frequency.length; i++){
            if(frequency[i] != 0) return false;
        }

        return true;
    }
}
