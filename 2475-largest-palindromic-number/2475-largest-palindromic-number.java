class Solution {
    public String largestPalindromic(String num) {
        int n = num.length();
        int freq[] = new int[10];
        for(int i=0; i<n; i++){
            char ch = num.charAt(i);
            freq[ch-48]++;
        }

        int oneOdd = -1;
        TreeMap<Integer, Integer> even = new TreeMap<>(Collections.reverseOrder());
        for(int i=9; i>=0; i--){
            if(freq[i] == 0) continue;

            if(freq[i] % 2==0)
            even.put(i, freq[i]);

            if(freq[i]%2 != 0){
                
                if(freq[i] > 1){
                    even.put(i, freq[i]-1);
                    
                }
            
            }
        }

        
            for(int i=9; i>=0; i--){
                if(freq[i]%2 != 0){
                    oneOdd = i;
                    break;
                }
            }
        

       // System.out.println(even);
        //System.out.println(oneOdd);

        StringBuilder firstHalf = new StringBuilder("");
        StringBuilder secondHalf = new StringBuilder("");
        String middle = String.valueOf(oneOdd);

        for(Integer key: even.keySet()){
            int f = even.get(key);
            String ch = String.valueOf(key);
            for(int i=0; i<f/2; i++){
                firstHalf.append(ch);
                secondHalf.insert(0, ch);
            }
        }
        String result="";

        if(oneOdd == -1){
            result = firstHalf.toString()+secondHalf.toString();
        }
        else
            result = firstHalf.toString()+middle+secondHalf.toString();

        String cleaned = result.replaceAll("^0+|0+$", "");

        if(cleaned.length() == 0)
        return "0";
        return cleaned;


    }
}