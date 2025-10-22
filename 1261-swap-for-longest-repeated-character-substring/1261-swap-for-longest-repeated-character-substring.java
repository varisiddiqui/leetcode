class Solution {
    public int maxRepOpt1(String s) {
       int n = s.length();
       

       HashMap<Character, Integer> hm = new HashMap<>();

       HashMap<Character, List<Integer>> pr = new HashMap<>();

       for(int i=0; i<n; i++){
        char ch = s.charAt(i);
        hm.put(ch, hm.getOrDefault(ch, 0) + 1); //for frequency
        pr.putIfAbsent(ch, new ArrayList<>()); //for presence
        pr.get(ch).add(i);
       }

       if(s.charAt(0) == s.charAt(n-1) && hm.get(s.charAt(0)) == n) return n;
       if(hm.size()==n) return 1;

       int max=0;

       for(Character key: pr.keySet()){
        List<Integer> li = pr.get(key);
        int n1=li.size();
        int genC=1;

        for(int i=0; i<n1-1; i++){
            
            if(li.get(i+1)-li.get(i)-1  > 0){ //if gap exist
        
            genC=0;
                //move left 
                int countL=1;
                int l=i;
                while(l-1>=0 && li.get(l)==li.get(l-1)+1){
                    l--;
                    countL++;
                }

                //move right
                int countR=1;
                int r=i+1;
                while(r+1<n1 && li.get(r+1)==li.get(r)+1){
                    r++;
                    countR++;
                }

                int continuous=0;
                if(li.get(i+1)-li.get(i)-1 == 1){
                    continuous += (countL+countR);

                    if(hm.get(key) > continuous){
                        continuous++;
                    }
                    max = Math.max(max, continuous);
                }
                else{
                    max = Math.max(max, Math.max(countL,countR)+1);
                }

            }
            else{
                genC++;
            }
        }
        max = Math.max(max, genC);
            

       }
       return max;



       

       
    }
}