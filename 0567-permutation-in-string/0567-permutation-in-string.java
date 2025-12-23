class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s2.length();
        int i=0;
        int j=0;
        int n1=s1.length();
        if(n1 > n) return false;

        System.out.println(n+" "+n1);
        HashMap<Character, Integer> valid = new HashMap<>();

        for(int k=0; k<n1; k++){
            char ch = s1.charAt(k);
            valid.put(ch, valid.getOrDefault(ch, 0) + 1);
        }

        HashMap<Character, Integer> variable = new HashMap<>();

        for(j=0; j<n1; j++){
            char ch = s2.charAt(j);
            variable.put(ch, variable.getOrDefault(ch, 0) + 1);
        }
        
        j--;



        while(j<n){
            boolean res = true;
            for(Character key: valid.keySet()){
                if (!valid.get(key).equals(variable.getOrDefault(key, 0))) {
                    res = false;
                    break;
                }
            }
            if(res) return true;

            char toRemove = s2.charAt(i++);
           
            j++;
            if(j<n){
                char toAdd = s2.charAt(j);
                 variable.put(toAdd, variable.getOrDefault(toAdd, 0) + 1);
            }
            else return false;
            
            
        

           // System.out.println(toAdd+" "+toRemove);

            if(variable.get(toRemove) > 1) variable.put(toRemove, variable.get(toRemove)-1);
            else variable.remove(toRemove);

        }
        return false;
    }
}