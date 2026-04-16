class Solution {
    public String predictPartyVictory(String senate) {
        char[] s = senate.toCharArray();
        int n = s.length;
        int totalR = 0, totalD = 0;

        for (char c : s) {
            if (c == 'R') totalR++;
            else totalD++;
        }

        int deadR = 0, deadD = 0;
        int banR = 0, banD = 0;  

        int i = 0;
        while (deadR < totalR && deadD < totalD) {
            if (s[i] == 'R') {
                if (banR > 0) {       
                    banR--;
                    deadR++;
                    s[i] = '*';       
                } else {
                    banD++;           
                }
            } else if (s[i] == 'D') {
                if (banD > 0) {       
                    banD--;
                    deadD++;
                    s[i] = '*';       
                } else {
                    banR++;           
                }
            }
            i = (i + 1) % n;         
        }

        return deadR == totalR ? "Dire" : "Radiant";
    }
}