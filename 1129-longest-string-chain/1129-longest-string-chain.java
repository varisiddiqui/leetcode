class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int n = words.length;
        
        if(n == 1)
        return 1;

        int dp[] = new int[n];
        Arrays.fill(dp, 1);


        for(int i=1; i<n; i++){
            for(int j=i-1; j>=0; j--){
                if(isPred(words[j], words[i])){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        
        int max=0;

        for(int i=0; i<n; i++){
            max = Math.max(dp[i], max);
        }


        return max;
    }

    public boolean isPred(String s1, String s2){
        if(Math.abs(s1.length() - s2.length()) != 1)
        return false;
        else{
            int n1 = s1.length();
            int n2 = s2.length();

            int i=0,j=0;
            int count=0;

            while(i<n1 && j<n2){
                if(s1.charAt(i) == s2.charAt(j)){
                    i++;
                    j++;
                }
                else{
                    j++;
                    count++;
                    if(count==2)
                    return false;
                }
            }
            if(i==n1)
            return true;
        }
        return false;
    }
}