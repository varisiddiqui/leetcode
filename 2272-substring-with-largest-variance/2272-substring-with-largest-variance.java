class Solution {
    public int largestVariance(String s) {
        int n = s.length();

        Set<Character> set = new HashSet<>();

        int ans=0;

        for(char ch: s.toCharArray()) set.add(ch);

        for(char i='a'; i<='z'; i++){
            if(!set.contains(i)) continue;
            for(char j='a'; j<='z'; j++){
                if(i == j || !set.contains(j)) continue;

                int cnt1=0;
                int cnt2=0;

                boolean lastSeen = false;

                for(char ch: s.toCharArray()){
                    if(ch == i) cnt1++;
                    if(ch == j) cnt2++;

                    if(cnt2 > 0){
        
                            ans = Math.max(ans, cnt1-cnt2);
                    
                    }

                    else if(lastSeen) ans = Math.max(ans, cnt1-1);

                    if(cnt2>cnt1){
                        cnt1=0;
                        cnt2=0;
                        lastSeen = true;
                    }
                }

                


            }
        }
        return ans;
    }
}