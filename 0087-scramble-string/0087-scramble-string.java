class Solution {
    public boolean isScramble(String s1, String s2) {
        HashMap<String, Boolean> dp = new HashMap<>();
        return isValid(s1, s2, dp);
    }

    public boolean isValid(String s1, String s2, HashMap<String, Boolean> dp){

        if(s1.equals(s2)) return true;

        String key = s1+"*"+s2;

        if(dp.containsKey(key)) return dp.get(key);

        

        int n1 = s1.length();
        int n2 = s2.length();

       
        if(n1 == 1) {
            dp.put(key, false);
            return false;
        }

        for(int i=0; i<n1-1; i++){ 

            int len = i+1;         

            if(isValid(s1.substring(0, len), s2.substring(0, len), dp) && isValid(s1.substring(len), s2.substring(len), dp)){
                dp.put(key, true);
                return true;
            }

            if(isValid(s1.substring(len), s2.substring(0, n1-len), dp) && isValid(s1.substring(0, len), s2.substring(n1-len), dp)){
                dp.put(key, true);
                return true;
            }

            
        }
        dp.put(key, false);

        return false;

    }
}