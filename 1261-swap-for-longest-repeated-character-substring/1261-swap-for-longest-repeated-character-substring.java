class Solution {
    public int maxRepOpt1(String s) {
        int n = s.length();
        int[] freq = new int[26];   // frequency of each character
        List<Integer>[] pos = new ArrayList[26];  // positions of each character

        for (int i = 0; i < 26; i++) pos[i] = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            int idx = ch - 'a';
            freq[idx]++;
            pos[idx].add(i);
        }

        if (s.charAt(0) == s.charAt(n - 1) && freq[s.charAt(0) - 'a'] == n) return n;

        int max = 0;

        for (int c = 0; c < 26; c++) {
            if (freq[c] == 0) continue;
            List<Integer> li = pos[c];
            int n1 = li.size();
            int genC = 1;

            for (int i = 0; i < n1 - 1; i++) {
                if (li.get(i + 1) - li.get(i) - 1 > 0) {  // gap exists
                    genC = 0;

                    // move left
                    int countL = 1;
                    int l = i;
                    while (l - 1 >= 0 && li.get(l) == li.get(l - 1) + 1) {
                        l--;
                        countL++;
                    }

                    // move right
                    int countR = 1;
                    int r = i + 1;
                    while (r + 1 < n1 && li.get(r + 1) == li.get(r) + 1) {
                        r++;
                        countR++;
                    }

                    int continuous = 0;
                    if (li.get(i + 1) - li.get(i) - 1 == 1) {
                        continuous = countL + countR;
                        if (freq[c] > continuous) continuous++;
                        max = Math.max(max, continuous);
                    } else {
                        max = Math.max(max, Math.max(countL, countR) + 1);
                    }
                } else {
                    genC++;
                }
            }
            max = Math.max(max, genC);
        }
        return max;
    }
}
