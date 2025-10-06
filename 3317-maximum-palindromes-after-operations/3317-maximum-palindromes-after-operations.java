class Solution {
    public int maxPalindromesAfterOperations(String[] words) {
        Map<Character, Integer> hm = new HashMap<>();
        int n = words.length;
        int wL[] = new int[n];
        for(int i=0; i<n; i++){
            wL[i] = words[i].length();
            for(int j=0; j<words[i].length(); j++){
                char ch = words[i].charAt(j);
                hm.put(ch, hm.getOrDefault(ch, 0) + 1);
            }
        }

        int even=0;
        int odd=0;
        for(Character key: hm.keySet()){
            if(hm.get(key)%2 ==0) even += hm.get(key);
            else{
                even += (hm.get(key)/2)*2;
                odd += hm.get(key)%2;
            }
        }

        Arrays.sort(wL);
        int count=0;
        for(int i=0; i<n; i++){
            if(wL[i]%2==0 ){
                if(even < wL[i]) continue;
                count++;
                even -= wL[i];
            }

            else{
                if(even>=wL[i]-1 && odd>0){
                    even -= (wL[i]-1);
                    odd--;
                    count++;
                }
                else if(even>=wL[i]){
                    even -= wL[i];
                    count++;
                }
            }
            
        }
        return count;

        
        
    }
}