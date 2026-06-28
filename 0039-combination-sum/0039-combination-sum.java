class Solution {
    Set<List<Integer>> ans = new HashSet<>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        

       
        subseq(0, candidates, new ArrayList<>(), target);

        return new ArrayList<>(ans);
        
    }

    public void subseq(int i, int[] candidates, List<Integer> li, int sum){
        if(i == candidates.length || sum<=0){
            if(sum == 0){
                ans.add(li);
            }
            return;
        }


        li.add(candidates[i]);
        subseq(i+1, candidates, new ArrayList<>(li), sum-candidates[i]);
        subseq(i, candidates, new ArrayList<>(li), sum-candidates[i]);

        li.remove(li.size()-1);
        subseq(i+1, candidates, new ArrayList<>(li), sum);
    }
}