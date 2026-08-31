class Solution {
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> partition(String s) {
        part(0, s, new ArrayList<>());
        return ans;
    }

    public void part(int idx, String s, List<String> li){
        if(idx == s.length()){
            ans.add(new ArrayList<>(li));
            return;
        }

        for(int i=idx; i<s.length(); i++){
            if(isPal(idx, i, s)){
                li.add(s.substring(idx, i+1));
               //System.out.println(li);
                part(i+1, s, li);
                li.remove(li.size()-1);
            }
        }
    }

    public boolean isPal(int st, int end, String s){
        while(st < end){
            if(s.charAt(st) != s.charAt(end)) return false;
            st++;
            end--;
        }
        return true;
    }
}