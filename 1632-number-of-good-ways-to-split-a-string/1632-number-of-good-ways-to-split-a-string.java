class Solution {
    public int numSplits(String s) {
        Set<Character> left = new HashSet<>();
        Set<Character> right = new HashSet<>();

        int n = s.length();
        int l[] = new int[n];
        int r[] = new int[n];
        for(int i=0; i<n; i++){
            left.add(s.charAt(i));
            l[i]=left.size();
        }

        for(int i=n-1; i>=0; i--){
            right.add(s.charAt(i));
            r[i]=right.size();
        }

        int equal=0;
        for(int i=0; i<n-1; i++){
            if(l[i] == r[i+1]) equal++;
        }

        return equal;

    }
}