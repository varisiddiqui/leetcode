class Solution {
    public int beautySum(String s) {
        int n = s.length();
        HashMap<Character, Integer> hm = new HashMap<>();
        int sum=0;

        for(int i=0; i<n; i++){
            
            for(int j=i; j<n; j++){
                int max = 0;
                int min = n+1;
                char ch = s.charAt(j);
                hm.put(ch, hm.getOrDefault(ch, 0)+1);

                for(char key: hm.keySet()){
                    min = Math.min(min, hm.get(key));
                    max = Math.max(max, hm.get(key));
                }
    
                
                
                sum += max-min;
            }
            hm.clear();
        }
        return sum;
    }
}