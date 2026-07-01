class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int n = candidates.length;
        Arrays.sort(candidates);

        int i = 0;

        subseq(i, candidates, target, new ArrayList<>());
        return ans;

    }

    public void subseq(int idx, int candidates[], int target, List<Integer> li){
        if(idx == candidates.length || target <=0){
            if(target == 0) ans.add(new ArrayList<>(li));
            return;
        }

        for(int i=idx; i<candidates.length; i++){ // for a particular index we consider
            if(i>idx && candidates[i] == candidates[i-1]) continue;
            if(candidates[i] > target) break;


                li.add(candidates[i]);
                subseq(i+1, candidates, target-candidates[i], li);
                li.remove(li.size()-1);    
            

        }
    }
    
}