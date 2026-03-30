class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       HashMap<Integer,Integer> mp = new HashMap<>();
       for(int i=0;i<nums.length;i++){
        if(mp.containsKey(nums[i])){
            int val = mp.get(nums[i]);
            val+=1;
            mp.put(nums[i],val);
        }
        else{
            mp.put(nums[i],1);
        }
       }
      List<Integer>[] bucket = new List[nums.length+1];
      int[] result = new int[k];
      for(int i=0;i<bucket.length;i++){
        bucket[i]=new ArrayList<>();
      }
      for(Integer key : mp.keySet()){
        int frequency = mp.get(key);
        bucket[frequency].add(key);
      }
      
      int count=0;
      for(int i=bucket.length-1;i>=0 && count<k ;i--){
        for(int n : bucket[i]){
            result[count]=n;
            count++;

        }
      }
      return result;
    }
    
}
