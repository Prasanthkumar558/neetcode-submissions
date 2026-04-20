class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
     Arrays.sort(candidates);
     getAllSet(candidates,target,0);
     return ans;

    }

    public void getAllSet(int[] candidates,int target,int index){

        if(target == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i =index; i<candidates.length;i++){

            if(candidates[i] > target) break;

            if(i > index && candidates[i] == candidates[i-1]) continue;

            temp.add(candidates[i]);
            getAllSet(candidates,target - candidates[i],i+1);

            temp.remove(temp.size()-1);
        }

    }
}
