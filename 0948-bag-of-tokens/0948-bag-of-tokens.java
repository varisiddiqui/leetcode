class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int n = tokens.length;
        if(n == 0) return 0;
        Arrays.sort(tokens);
        int i=0;
        int j=n-1;
        int max=0;
        int score=0;
        if(tokens[0] > power) return 0;
        if(n == 1) return (power>=tokens[0])?1: 0;

        while(i<j){
            while(i<n && power >= tokens[i]){
                power -= tokens[i];
               // System.out.println(power);
                score += 1;
                max = Math.max(max, score);
                i++;
            }
        
            if(i==n-1 || i==n) break;
            if((power+tokens[j]) >= tokens[i]){                
                power += tokens[j];
               // System.out.println(power);
                score -= 1;
                j--;
                if(i==j){
                    score += 1;
                    break;
                }
            }
            
        }
        return max;
    }
}