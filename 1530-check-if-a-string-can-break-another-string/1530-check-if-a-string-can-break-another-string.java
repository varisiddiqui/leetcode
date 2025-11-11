class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        int n = s2.length();
        int ch1 [] = new int[26];
        int ch2 [] = new int[26];

        for(int i=0; i<n; i++){
            ch1[s1.charAt(i) - 'a']++;
            ch2[s2.charAt(i) - 'a']++;
        }   

        return isPoss(ch1, ch2) || isPoss(ch2, ch1);
    }

    boolean isPoss(int a[], int b[]){
        int sumA=0;
        int sumB=0;
        for(int i=0; i<26; i++){
            sumA += a[i];
            sumB += b[i];

            if(sumA < sumB) return false;
        }
        return true;
    }
}