class Solution {
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> partition(String s) {
        poss(new ArrayList<>(), 0, s);
        return ans;
    }   

    public boolean isPal(String s, int st, int end){

        while(st < end){
            if(s.charAt(st) != s.charAt(end)) return false;
            st++;
            end--;
        }
        return true;
    }

    public void poss(List<String> curr, int idx, String s){
        if(idx == s.length()){
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i=idx ; i<s.length(); i++){
            if(isPal(s, idx, i)){
                curr.add(s.substring(idx, i+1));
                poss(curr, i+1, s);
                curr.remove(curr.size()-1);
            }
        }
    }
}