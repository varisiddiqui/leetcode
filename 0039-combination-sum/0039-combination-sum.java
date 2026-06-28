class Solution {
        List<List<Integer>> ans = new ArrayList<>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        

       
        subseq(0, candidates, new ArrayList<>(), target);

        return new ArrayList<>(ans);
        
    }

    public void subseq(int i, int[] candidates, List<Integer> li, int sum){
        if(i == candidates.length || sum<=0){
            if(sum == 0){
                ans.add(new ArrayList<>(li));
            }
            return;
        }


        li.add(candidates[i]);
        subseq(i, candidates, li, sum-candidates[i]);

        li.remove(li.size()-1);
       
        subseq(i+1, candidates, li, sum);
    }
}