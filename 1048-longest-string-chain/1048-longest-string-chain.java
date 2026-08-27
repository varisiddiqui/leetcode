class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;

        Comparator<String> cmp = (a, b) -> {
            return a.length()-b.length();
        };

        Arrays.sort(words, cmp);

        int dp[] = new int[n];
       

        Arrays.fill(dp, 1);
        int max=1;

        for(int i=1; i<n; i++){
            for(int j=i-1; j>=0; j--){
                if(isEqual(words[j], words[i]) && dp[i] < dp[j]+1){
                    dp[i] = dp[j]+1;
                   
                }
            }

            if(max < dp[i]){
                max = dp[i];
             
            }
        }


        return max;



        
    }

    public boolean isEqual(String s1, String s2){
        int i=0;
        int j=0;

        int n1 = s1.length();
        int n2 = s2.length();

        int lf=1;

        if(Math.abs(n1-n2) != 1) return false;

        while(i<n1 && j<n2){
            if(s1.charAt(i) != s2.charAt(j)){
                if(lf == 0) return false;
                lf=0;
                if(n1 < n2) j++;
                else i++;                
            }
            else {
            i++;
            j++;
            }
            
        }
        return true;
    }
}