class Solution {
    public int maxLength(List<String> arr) {
        return max(0, new ArrayList<>(), arr);
        
    }

    public int max(int idx, List<String> li, List<String> arr){
            int n = arr.size();
            if(idx == n) return 0;

            int max=0;

            String curr = arr.get(idx);
       
            if(isValid(curr, li)){
                //take
                li.add(curr);
                max = Math.max(max, curr.length()+max(idx+1, li, arr));
                li.remove(li.size()-1);
            }   

            //not take
            max = Math.max(max, max(idx+1, li, arr));

            return max;
            
        }
    

    public boolean isValid(String s, List<String> li){
        Set<Character> set = new HashSet<>();

        for(char ch: s.toCharArray()) {
            if(set.isEmpty() || !set.contains(ch)) set.add(ch);
            else return false;
        }

        

        for(String st: li){
            for(char ch: st.toCharArray()){
                if(set.contains(ch)) return false;
            }
            
        }

        return true;
    }
}